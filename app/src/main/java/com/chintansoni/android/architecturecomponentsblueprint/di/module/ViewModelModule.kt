package com.chintansoni.android.architecturecomponentsblueprint.di.module

import android.arch.lifecycle.ViewModelProvider
import com.chintansoni.android.architecturecomponentsblueprint.di.module.viewmodelmodule.activityviewmodel.SplashActivityViewModelModule
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.KotlinViewModelFactory
import dagger.Binds
import dagger.Module

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

@Module(includes = [
    (SplashActivityViewModelModule::class)
])
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: KotlinViewModelFactory): ViewModelProvider.Factory
}