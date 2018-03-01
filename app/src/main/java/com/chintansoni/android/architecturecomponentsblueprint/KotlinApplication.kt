package com.chintansoni.android.architecturecomponentsblueprint

import android.app.Activity
import android.app.Application
import com.chintansoni.android.architecturecomponentsblueprint.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by chint on 2/20/2018.
 */
class KotlinApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initializeLogger()
        initializeAppInjector()
    }

    private fun initializeAppInjector() {
        AppInjector.init(this)
    }

    private fun initializeLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }
}