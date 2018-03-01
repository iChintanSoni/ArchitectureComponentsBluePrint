package com.chintansoni.android.architecturecomponentsblueprint.di.module

import com.chintansoni.android.architecturecomponentsblueprint.view.activity.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by chintan.soni on 21/02/18.
 */
@Module
abstract class SplashActivityModule {
    @ContributesAndroidInjector(modules = [(FragmentBuildersModule::class)])
    internal abstract fun contributeSplashActivity(): SplashActivity
}