package com.chintansoni.android.architecturecomponentsblueprint.base

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chintansoni.android.architecturecomponentsblueprint.di.Injectable
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.KotlinViewModelFactory
import javax.inject.Inject


/**
 * Created by yashsoni on 02/03/18.
 */
abstract class BaseFragment<FragmentDataBinding : ViewDataBinding> : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: KotlinViewModelFactory

    protected lateinit var binding: FragmentDataBinding

    abstract fun getLayoutResource(): Int

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false)
        return binding.root
    }

    protected fun <T : BaseViewModel> getViewModel(viewModelClass: Class<T>, kotlinViewModelFactory: KotlinViewModelFactory): T {
        return ViewModelProviders.of(this, kotlinViewModelFactory).get(viewModelClass)
    }
}