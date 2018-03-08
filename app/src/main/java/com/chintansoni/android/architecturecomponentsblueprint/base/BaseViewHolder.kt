package com.chintansoni.android.architecturecomponentsblueprint.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.chintansoni.android.architecturecomponentsblueprint.BR

/**
 * Created by chint on 3/9/2018.
 */
abstract class BaseViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var viewModel: Any
    private lateinit var model: Any

    @JvmOverloads
    fun bind(position: Int, viewModel: Any, obj: Any? = null) {
        this.viewModel = viewModel
        binding.setVariable(BR.viewModel, viewModel)
        if (obj != null) {
            this.model = obj
//            binding.setVariable(BR.model, obj)
        }
        binding.executePendingBindings()
        onBind(position, viewModel, obj)
    }

    abstract fun onBind(position: Int, viewModel: Any, obj: Any?)
}
