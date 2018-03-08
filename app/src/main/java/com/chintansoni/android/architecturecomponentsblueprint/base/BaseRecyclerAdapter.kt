package com.chintansoni.android.architecturecomponentsblueprint.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.lang.reflect.InvocationTargetException
import java.util.*

/**
 * Created by chint on 3/9/2018.
 */
class BaseRecyclerAdapter<T, U : BaseViewHolder, V : BaseViewHolder>(
        private val viewModel: Any,
        @field:LayoutRes private val emptyViewLayoutResource: Int,
        private val emptyViewHolder: Class<U>,
        @field:LayoutRes private val dataLayoutResource: Int,
        private val dataViewHolder: Class<V>) : RecyclerView.Adapter<BaseViewHolder>() {

    private var list: MutableList<T>

    init {
        list = ArrayList()
    }

    val listSize: Int
        get() = list.size

    val items: List<T>
        get() = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        try {
            val baseViewHolder: BaseViewHolder
            val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), if (viewType == VIEW_TYPE_EMPTY) emptyViewLayoutResource else dataLayoutResource, parent, false)
            baseViewHolder = if (viewType == VIEW_TYPE_EMPTY) emptyViewHolder.getConstructor(ViewDataBinding::class.java).newInstance(binding) else dataViewHolder.getConstructor(ViewDataBinding::class.java).newInstance(binding)
            return baseViewHolder
        } catch (e: NoSuchMethodException) {
            throw RuntimeException(e)
        } catch (e: InvocationTargetException) {
            throw RuntimeException(e)
        } catch (e: InstantiationException) {
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException(e)
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == VIEW_TYPE_EMPTY) {
            holder.bind(position, viewModel)
            customEmptyBind(holder, viewModel)
        } else {
            holder.bind(position, viewModel, list[position])
            customBind(holder, position, list[position], viewModel)
        }
    }

    protected fun customEmptyBind(holder: BaseViewHolder, viewModel: Any) {

    }

    protected fun customBind(holder: BaseViewHolder, position: Int, model: T, viewModel: Any) {

    }

    override fun getItemCount(): Int {
        return if (list.size == 0) 1 else list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (list.size == 0) VIEW_TYPE_EMPTY else VIEW_TYPE_DATA
    }

    fun setList(itemList: MutableList<T>) {
        this.list = itemList
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > -1 && position < list.size) {
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun addItem(data: T, position: Int) {
        if (position <= list.size) {
            list.add(position, data)
            notifyItemInserted(position)
        }
    }

    fun addItem(data: T) {
        //addItem(data, list.size());
        list = ArrayList()
        list.add(data)
        notifyDataSetChanged()
    }

    fun clearItems() {
        val size = list.size
        if (size > 0) {
            list.clear()
            notifyItemRangeRemoved(0, size)
        }
    }

    private fun addItems(data: List<T>?, position: Int) {
        if (position <= list.size && data != null && data.size > 0) {
            list.addAll(position, data)
            notifyItemRangeChanged(position, data.size)
        }
    }

    fun addItems(data: List<T>) {
        addItems(data, list.size)
    }

    companion object {
        private val VIEW_TYPE_EMPTY = 0
        private val VIEW_TYPE_DATA = 1
    }
}
