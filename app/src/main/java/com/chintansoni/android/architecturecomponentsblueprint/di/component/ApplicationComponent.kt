package com.chintansoni.android.architecturecomponentsblueprint.di.component

import android.app.Application
import com.chintansoni.android.architecturecomponentsblueprint.KotlinApplication
import com.chintansoni.android.architecturecomponentsblueprint.di.module.ActivityModule
import com.chintansoni.android.architecturecomponentsblueprint.di.module.AppModule
import com.chintansoni.android.architecturecomponentsblueprint.di.module.FragmentModule
import com.chintansoni.android.architecturecomponentsblueprint.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by chint on 2/20/2018.
 */
@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (ActivityModule::class),
    (FragmentModule::class),
    (ViewModelModule::class)
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(kotlinApplication: KotlinApplication)
}