package com.chintansoni.android.architecturecomponentsblueprint.di.module.fragmentmodule

import com.chintansoni.android.architecturecomponentsblueprint.view.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by yashsoni on 02/03/18.
 */
@Module
abstract class HomeFragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeRepoFragment(): HomeFragment
}