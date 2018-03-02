package com.chintansoni.android.architecturecomponentsblueprint.di.module

import com.chintansoni.android.architecturecomponentsblueprint.di.module.activitymodule.HomeActivityModule
import com.chintansoni.android.architecturecomponentsblueprint.di.module.activitymodule.SplashActivityModule
import dagger.Module

/**
 * Created by yashsoni on 02/03/18.
 */

/**
 * A class as a common place for registering your Activity to make it as injectable.
 * When creating a new Activity, don't forget to create an {Name-Prefix}ActivityModule.kt
 * in package activitymodule
 *
 * Once created, simply register it here by adding it into includes Array
 */
@Module(includes = [
    (SplashActivityModule::class),
    (HomeActivityModule::class)
])
class ActivityModule