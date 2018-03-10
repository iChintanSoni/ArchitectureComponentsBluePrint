package com.chintansoni.android.architecturecomponentsblueprint.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.lang.reflect.InvocationTargetException

/**
 * Created by chint on 3/9/2018.
 */
class BaseRecyclerAdapter<VIEW, MODEL, EMPTYVIEWHOLDER : BaseViewHolder<VIEW>, MODELVIEWHOLDER : BaseViewHolder<VIEW>>() : RecyclerView.Adapter<BaseViewHolder<VIEW>>() {

    @field:LayoutRes
    private var emptyLayoutResource: Int = 0

    private lateinit var emptyViewHolder: Class<EMPTYVIEWHOLDER>

    @field:LayoutRes
    private var modelLayoutResource: Int = 0

    private lateinit var modelViewHolder: Class<MODELVIEWHOLDER>

    private var view: VIEW? = null

    constructor(view: VIEW,
                emptyLayoutResource: Int,
                emptyViewHolder: Class<EMPTYVIEWHOLDER>,
                modelLayoutResource: Int,
                modelViewHolder: Class<MODELVIEWHOLDER>) : this() {
        this.view = view
        this.emptyLayoutResource = emptyLayoutResource
        this.emptyViewHolder = emptyViewHolder
        this.modelLayoutResource = modelLayoutResource
        this.modelViewHolder = modelViewHolder
    }

    private var list: ArrayList<MODEL?>

    init {
        list = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VIEW> {
        try {
            val binding = DataBindingUtil.inflate<ViewDataBinding>(
                    LayoutInflater.from(parent.context),
                    if (viewType == VIEW_TYPE_EMPTY) emptyLayoutResource else modelLayoutResource,
                    parent,
                    false)
            return if (viewType == VIEW_TYPE_EMPTY) emptyViewHolder.getConstructor(ViewDataBinding::class.java).newInstance(binding) else modelViewHolder.getConstructor(ViewDataBinding::class.java).newInstance(binding)
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

    override fun onBindViewHolder(holder: BaseViewHolder<VIEW>, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == VIEW_TYPE_EMPTY) {
            holder.bind(view)
        } else {
            holder.bind(view, list[position])
        }
    }

    override fun getItemCount(): Int {
        return if (list.size == 0) 1 else list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (list.size == 0) VIEW_TYPE_EMPTY else VIEW_TYPE_DATA
    }

    fun setItems(itemList: ArrayList<MODEL?>) {
        this.list = itemList
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > -1 && position < list.size) {
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun addItem(data: MODEL, position: Int) {
        if (position <= list.size) {
            list.add(position, data)
            notifyItemInserted(position)
        }
    }

    fun clearItems() {
        val size = list.size
        if (size > 0) {
            list.clear()
            notifyItemRangeRemoved(0, size)
        }
    }

    private fun addItems(data: List<MODEL>?, position: Int) {
        if (position <= list.size && data != null && data.isNotEmpty()) {
            list.addAll(position, data)
            notifyItemRangeChanged(position, data.size)
        }
    }

    fun addItems(data: List<MODEL>) {
        addItems(data, list.size)
    }

    companion object {
        private const val VIEW_TYPE_EMPTY = 0
        private const val VIEW_TYPE_DATA = 1
    }
}
