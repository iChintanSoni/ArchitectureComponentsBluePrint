package com.chintansoni.android.architecturecomponentsblueprint.view.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseActivity
import com.chintansoni.android.architecturecomponentsblueprint.model.Status
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel.SplashActivityViewModel
import kotlinx.android.synthetic.main.content_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    override fun getLayoutResource(): Int = R.layout.activity_splash

    @Inject
    lateinit var splashActivityViewModel: SplashActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.splashActivityViewModel = getViewModel(SplashActivityViewModel::class.java)
        listenForWait()
    }

    private fun listenForWait() {
        splashActivityViewModel.isFirstTime().observe(this, Observer {
            if (it != null) {
                if (it.status == Status.SUCCESS || it.status == Status.ERROR) {
                    if (it.data!!)
                        showGetStartedButton()
                    else
                        navigateToHome()
                }
            }
        })
    }

    private fun showGetStartedButton() {
        val animationFade = AnimationUtils.makeInAnimation(this, true)
        btn_splash.apply {
            animation = animationFade
            visibility = View.VISIBLE
        }
        btn_splash.animate()
    }

    fun onGetStartedClick(view: View) {
        splashActivityViewModel.setAsFirstTime()
        navigateToHome()
    }

    private fun navigateToHome() {
        launchActivityFinishCurrent(HomeActivity.getActivityIntent(this))
    }
}
