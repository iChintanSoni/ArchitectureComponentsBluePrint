package com.chintansoni.android.architecturecomponentsblueprint.model.repository

import android.arch.lifecycle.MediatorLiveData
import com.chintansoni.android.architecturecomponentsblueprint.model.Resource
import com.chintansoni.android.architecturecomponentsblueprint.model.preference.FirstTimePreference
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by chintan.soni on 23/02/18.
 */
@Singleton
class SplashRepository @Inject constructor(private var firstTimePreference: FirstTimePreference) {

    private val result = MediatorLiveData<Resource<Boolean>>()
    private val delayTimeInMS = 3

    fun checkIfFirstTime() {
        Maybe.empty<Boolean>()
                .delay(delayTimeInMS.toLong(), TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete({
                    result.value = Resource.success(firstTimePreference.isFirstTimePreference())
                })
                .doOnError({
                    result.value = Resource.error("Issue with observable", firstTimePreference.isFirstTimePreference())
                })
                .subscribe()
    }

    fun asLiveData(): MediatorLiveData<Resource<Boolean>> {
        checkIfFirstTime()
        return result
    }

    init {
        result.value = Resource.loading(null)
    }
}