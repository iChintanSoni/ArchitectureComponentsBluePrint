package com.chintansoni.android.architecturecomponentsblueprint.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.chintansoni.android.architecturecomponentsblueprint.di.mapkey.ViewModelKey
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.KotlinViewModelFactory
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel.HomeActivityViewModel
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel.SplashActivityViewModel
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.fragmentviewmodel.NetworkCallFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by chintan.soni on 23/02/18.
 */

/**
 * A class as a common place for registering your ViewModels, to make it as injectable.
 * When creating a new ViewModel, don't forget to create a {Name-Prefix}ViewModelModule.kt
 * in package viewmodelmodule
 *
 * Once created, simply register it here by adding it into includes Array
 */

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NetworkCallFragmentViewModel::class)
    abstract fun bindNetworkCallFragmentViewModel(networkCallFragmentViewModel: NetworkCallFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(homeActivityViewModel: HomeActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel::class)
    abstract fun bindSplashViewModel(splashActivityActivity: SplashActivityViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: KotlinViewModelFactory): ViewModelProvider.Factory
}