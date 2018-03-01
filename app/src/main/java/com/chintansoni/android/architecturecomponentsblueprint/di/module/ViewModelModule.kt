package com.chintansoni.android.architecturecomponentsblueprint.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseViewModel
import com.chintansoni.android.architecturecomponentsblueprint.di.mapkey.ViewModelKey
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.KotlinViewModelFactory
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by chintan.soni on 23/02/18.
 */
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindUserViewModel(splashActivityModule: SplashViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: KotlinViewModelFactory): ViewModelProvider.Factory
}