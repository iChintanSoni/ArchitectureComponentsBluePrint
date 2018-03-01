package com.chintansoni.android.architecturecomponentsblueprint.view.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseActivity
import com.chintansoni.android.architecturecomponentsblueprint.model.Status
import com.chintansoni.android.architecturecomponentsblueprint.model.preference.FirstTimePreference
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.KotlinViewModelFactory
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.content_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    override fun getLayoutResource(): Int = R.layout.activity_splash

    @Inject
    lateinit var viewModelFactory: KotlinViewModelFactory

    private lateinit var splashViewModel: SplashViewModel

    @Inject
    lateinit var firstTimePreference: FirstTimePreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.splashViewModel = getViewModel(viewModelFactory, SplashViewModel::class.java)

        listenForWait()
    }

    private fun listenForWait() {
        splashViewModel.isFirstTime().observe(this, Observer {
            if (it != null) {
                if (it.status == Status.SUCCESS || it.status == Status.ERROR) {
                    if (it.data!!)
                        btn_splash.visibility = View.VISIBLE
//                    else
//                        navigateToHome(btn_splash)
                }
            }
        })
    }

    private fun navigateToHome(view: View) {
        firstTimePreference.setFirstTimePreference()
        launchActivity(HomeActivity.getActivityIntent(this))
    }
}
