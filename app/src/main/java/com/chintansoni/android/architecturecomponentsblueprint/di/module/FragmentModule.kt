package com.chintansoni.android.architecturecomponentsblueprint.di.module

import com.chintansoni.android.architecturecomponentsblueprint.di.module.fragmentmodule.HomeFragmentModule
import dagger.Module

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

@Module(includes = [
    (HomeFragmentModule::class)
])
abstract class FragmentModule