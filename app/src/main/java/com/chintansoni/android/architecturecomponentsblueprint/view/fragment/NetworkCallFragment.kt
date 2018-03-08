package com.chintansoni.android.architecturecomponentsblueprint.view.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseFragment
import com.chintansoni.android.architecturecomponentsblueprint.databinding.NetworkCallFragmentDataBinding
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.KotlinViewModelFactory
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.fragmentviewmodel.NetworkCallFragmentViewModel
import kotlinx.android.synthetic.main.fragment_network_call.*
import javax.inject.Inject


/**
 * Created by yashsoni on 02/03/18.
 */
class NetworkCallFragment : BaseFragment<NetworkCallFragmentDataBinding>() {

    @Inject
    lateinit var viewModelFactory: KotlinViewModelFactory

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Initializing ViewModel
        networkCallFragmentViewModel = getViewModel(NetworkCallFragmentViewModel::class.java, viewModelFactory)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_network_call
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        networkCallFragmentViewModel.getLiveDataUsers().observe(this, Observer {
            if (it != null) {
//                binding.viewModel= it.status == Status.LOADING

            }

        })

        val dividerItemDecoration = DividerItemDecoration(context, (rv_network_call.layoutManager as LinearLayoutManager).orientation)
        rv_network_call.addItemDecoration(dividerItemDecoration)
    }
}