package com.chintansoni.android.architecturecomponentsblueprint.di.module.activitymodule

import com.chintansoni.android.architecturecomponentsblueprint.view.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by chintan.soni on 21/02/18.
 */
@Module
abstract class HomeActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeHomeActivity(): HomeActivity
}