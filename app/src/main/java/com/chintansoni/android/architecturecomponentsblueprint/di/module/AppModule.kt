package com.chintansoni.android.architecturecomponentsblueprint.di.module

import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiService
import com.chintansoni.android.architecturecomponentsblueprint.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by chint on 2/21/2018.
 */
@Module(includes = [(ViewModelModule::class)])
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

//    @Singleton
//    @Provides
//    fun provideDb(app: Application): GithubDb {
//        return Room.databaseBuilder(app, GithubDb::class.java!!, "github.db").build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideUserDao(db: GithubDb): UserDao {
//        return db.userDao()
//    }
//
//    @Singleton
//    @Provides
//    fun provideRepoDao(db: GithubDb): RepoDao {
//        return db.repoDao()
//    }
}