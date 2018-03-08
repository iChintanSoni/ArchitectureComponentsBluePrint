package com.chintansoni.android.architecturecomponentsblueprint.di.module

import android.app.Application
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiService
import com.chintansoni.android.architecturecomponentsblueprint.model.database.UserDatabase
import com.chintansoni.android.architecturecomponentsblueprint.model.database.dao.UserDao
import com.chintansoni.android.architecturecomponentsblueprint.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by chint on 2/21/2018.
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideUserDatabase(app: Application): UserDatabase = UserDatabase.getInstance(app)!!

    @Singleton
    @Provides
    fun provideUserDao(database: UserDatabase): UserDao = database.userDao()
}