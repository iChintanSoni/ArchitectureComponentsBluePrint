package com.chintansoni.android.architecturecomponentsblueprint.di.module

import android.app.Application
import com.chintansoni.android.architecturecomponentsblueprint.BuildConfig
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiService
import com.chintansoni.android.architecturecomponentsblueprint.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import javax.inject.Singleton

/**
 * Created by chint on 2/21/2018.
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.tag("OkHttp").d(message) })
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun okHttpClient(cache: Cache, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    @Provides
    @Singleton
    fun cache(file: File): Cache {
        return Cache(file, 10 * 1000 * 1000) // 10 mb cache file
    }

    @Provides
    @Singleton
    fun file(application: Application): File {
        val file = File(application.cacheDir, "OkHttpCache")
        file.mkdirs()
        return file
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