package com.chintansoni.android.architecturecomponentsblueprint.view.viewholder

import android.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseViewHolder
import com.chintansoni.android.architecturecomponentsblueprint.databinding.ListItemNetworkCallModelBinding
import com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response.ResultsItem
import com.chintansoni.android.architecturecomponentsblueprint.view.fragment.NetworkCallFragment

/**
 * Created by chintan.soni on 10/03/18.
 */
class ResultModelViewHolder(binding: ViewDataBinding) : BaseViewHolder<NetworkCallFragment>(binding) {

    override fun onBind() {
        Glide.with(binding.root.context)
                .load((model as ResultsItem).picture?.thumbnail)
                .into((binding as ListItemNetworkCallModelBinding).ivListItemNetworkCall)
    }
}