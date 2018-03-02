package com.chintansoni.android.architecturecomponentsblueprint.view.fragment

import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseFragment
import com.chintansoni.android.architecturecomponentsblueprint.databinding.HomeFragmentDataBinding

/**
 * Created by yashsoni on 02/03/18.
 */
class HomeFragment : BaseFragment<HomeFragmentDataBinding>() {

    override fun getLayoutResource(): Int {
        return R.layout.fragment_home
    }

}