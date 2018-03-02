package com.chintansoni.android.architecturecomponentsblueprint.di.module.viewmodelmodule.fragmentviewmodel

import android.arch.lifecycle.ViewModel
import com.chintansoni.android.architecturecomponentsblueprint.di.mapkey.ViewModelKey
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel.HomeActivityViewModel
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel.SplashActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by yashsoni on 02/03/18.
 */
@Module
abstract class HomeActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(homeActivityViewModelModule: HomeActivityViewModel): ViewModel
}