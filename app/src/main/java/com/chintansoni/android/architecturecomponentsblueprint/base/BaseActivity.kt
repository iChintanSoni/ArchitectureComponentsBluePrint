package com.chintansoni.android.architecturecomponentsblueprint.base

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.chintansoni.android.architecturecomponentsblueprint.util.ActivityNavigatorUtils
import com.chintansoni.android.architecturecomponentsblueprint.util.FragmentNavigationUtils
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.KotlinViewModelFactory
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by chint on 11/22/2017.
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: KotlinViewModelFactory

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
    }

    abstract fun getLayoutResource(): Int

    protected fun <T : BaseViewModel> getViewModel(viewModelClass: Class<T>): T {
        return ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }

    fun launchActivityFinishCurrent(intent: Intent) {
        ActivityNavigatorUtils.launchActivity(this, intent, true)
    }

    fun launchActivity(intent: Intent) {
        ActivityNavigatorUtils.launchActivity(this, intent)
    }

    fun launchActivityWithRequestCode(intent: Intent, requestCode: Int) {
        ActivityNavigatorUtils.launchActivity(this, intent, requestCode)
    }

    fun addFragment(fragment: Fragment, containerId: Int) {
        FragmentNavigationUtils.addFragment(this, fragment, containerId)
    }

    fun addFragment(fragment: Fragment, containerId: Int, shouldBeAddedToBackStack: Boolean) {
        FragmentNavigationUtils.addFragment(this, fragment, containerId, shouldBeAddedToBackStack)
    }

    fun replaceFragment(fragment: Fragment, containerId: Int) {
        FragmentNavigationUtils.replaceFragment(this, fragment, containerId)
    }

    fun replaceFragment(fragment: Fragment, containerId: Int, shouldBeAddedToBackStack: Boolean) {
        FragmentNavigationUtils.replaceFragment(this, fragment, containerId, shouldBeAddedToBackStack)
    }
}