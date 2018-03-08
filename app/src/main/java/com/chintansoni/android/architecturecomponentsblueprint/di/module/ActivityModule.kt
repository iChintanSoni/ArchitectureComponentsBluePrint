package com.chintansoni.android.architecturecomponentsblueprint.di.module

import com.chintansoni.android.architecturecomponentsblueprint.view.activity.HomeActivity
import com.chintansoni.android.architecturecomponentsblueprint.view.activity.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by yashsoni on 02/03/18.
 */

/**
 * A class as a common place for registering your Activity to make it as injectable.
 * When creating a new Activity, don't forget to create an method contribute{ActivityName} returning the same Activity
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    internal abstract fun contributeHomeActivity(): HomeActivity
}