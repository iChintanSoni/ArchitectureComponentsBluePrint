package com.chintansoni.android.architecturecomponentsblueprint.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chintansoni.android.architecturecomponentsblueprint.di.Injectable


/**
 * Created by yashsoni on 02/03/18.
 */
abstract class BaseFragment<FragmentDatabinding : ViewDataBinding> : Fragment(), Injectable {
    protected lateinit var binding: FragmentDatabinding

    abstract fun getLayoutResource(): Int

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false)
        return binding.root
    }
}