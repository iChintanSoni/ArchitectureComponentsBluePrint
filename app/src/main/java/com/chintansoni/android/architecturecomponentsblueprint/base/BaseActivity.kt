package com.chintansoni.android.architecturecomponentsblueprint.base

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.chintansoni.android.architecturecomponentsblueprint.util.ActivityNavigatorUtils
import com.chintansoni.android.architecturecomponentsblueprint.util.SharedPrefsUtils
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

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
    }

    abstract fun getLayoutResource(): Int

    protected fun <T : BaseViewModel> getViewModel(viewModelFactory: KotlinViewModelFactory, viewModelClass: Class<T>): T {
        return ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }

    protected fun registerPreferenceListener(onSharedPreferenceChangeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
        SharedPrefsUtils.registerObserver(this, onSharedPreferenceChangeListener)
    }

    protected fun unRegisterPreferenceListener(onSharedPreferenceChangeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
        SharedPrefsUtils.unRegisterObserver(this, onSharedPreferenceChangeListener)
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
}