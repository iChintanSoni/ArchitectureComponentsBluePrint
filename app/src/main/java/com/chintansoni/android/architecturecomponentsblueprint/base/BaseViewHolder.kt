package com.chintansoni.android.architecturecomponentsblueprint.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.chintansoni.android.architecturecomponentsblueprint.BR

/**
 * Created by chint on 3/9/2018.
 */
abstract class BaseViewHolder<in VIEW>(private var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    private var view: VIEW? = null

    private lateinit var model: Any

    fun bind(view: VIEW?, obj: Any? = null) {
        binding.setVariable(BR.view, view)
        if (obj != null) {
            this.model = obj
            binding.setVariable(BR.model, obj)
        }
        binding.executePendingBindings()
    }
}
