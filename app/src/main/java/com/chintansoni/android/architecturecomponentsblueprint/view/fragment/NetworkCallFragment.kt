package com.chintansoni.android.architecturecomponentsblueprint.view.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseFragment
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseRecyclerAdapter
import com.chintansoni.android.architecturecomponentsblueprint.databinding.NetworkCallFragmentDataBinding
import com.chintansoni.android.architecturecomponentsblueprint.model.Status
import com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response.ResultsItem
import com.chintansoni.android.architecturecomponentsblueprint.view.viewholder.ResultEmptyViewHolder
import com.chintansoni.android.architecturecomponentsblueprint.view.viewholder.ResultModelViewHolder
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.fragmentviewmodel.NetworkCallFragmentViewModel
import kotlinx.android.synthetic.main.fragment_network_call.*
import javax.inject.Inject


/**
 * Created by yashsoni on 02/03/18.
 */
class NetworkCallFragment : BaseFragment<NetworkCallFragmentDataBinding>() {

    private var randomUserAdapter: BaseRecyclerAdapter<NetworkCallFragment, ResultsItem, ResultEmptyViewHolder, ResultModelViewHolder> = BaseRecyclerAdapter(this, R.layout.list_item_network_call_empty, ResultEmptyViewHolder::class.java, R.layout.list_item_network_call_model, ResultModelViewHolder::class.java)

    companion object {
        fun getFragment(): NetworkCallFragment {
            return NetworkCallFragment()
        }
    }

    @Inject
    lateinit var networkCallFragmentViewModel: NetworkCallFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This is used for retaining this Fragment on Configuration Changes
        retainInstance = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Initializing ViewModel
        networkCallFragmentViewModel = getViewModel(NetworkCallFragmentViewModel::class.java, viewModelFactory)
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_network_call
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        networkCallFragmentViewModel.getLiveDataUsers().observe(this, Observer {
            if (it != null) {
                binding.loading = it.status == Status.LOADING
                if (it.status == Status.SUCCESS) {
                    randomUserAdapter.setItems(it.data!!.body!!.results!!)
                }
            }
        })


        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        val dividerItemDecoration = DividerItemDecoration(context, (rv_network_call.layoutManager as LinearLayoutManager).orientation)
        rv_network_call.addItemDecoration(dividerItemDecoration)
        rv_network_call.adapter = randomUserAdapter
    }
}