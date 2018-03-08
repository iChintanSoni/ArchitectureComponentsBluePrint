package com.chintansoni.android.architecturecomponentsblueprint.di.module

import com.chintansoni.android.architecturecomponentsblueprint.view.fragment.HomeFragment
import com.chintansoni.android.architecturecomponentsblueprint.view.fragment.NetworkCallFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by chintan.soni on 21/02/18.
 */

/**
 * A class as a common place for registering your Fragment, to make it as injectable.
 * When creating a new Fragment, don't forget to create a {Name-Prefix}FragmentModule.kt
 * in package fragmentmodule
 *
 * Once created, simply register it here by adding it into includes Array
 */

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeRepoFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeNetworkCallFragment(): NetworkCallFragment
}