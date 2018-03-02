package com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel

import android.arch.lifecycle.LiveData
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseViewModel
import com.chintansoni.android.architecturecomponentsblueprint.model.Resource
import com.chintansoni.android.architecturecomponentsblueprint.model.repository.SplashRepository
import javax.inject.Inject

/**
 * Created by chint on 2/18/2018.
 */
class SplashActivityViewModel() : BaseViewModel() {

    private lateinit var isFirstTime: LiveData<Resource<Boolean>>

    private lateinit var splashRepository: SplashRepository

    @Inject
    constructor(splashRepository: SplashRepository) : this() {
        this.splashRepository = splashRepository
    }

    fun isFirstTime(): LiveData<Resource<Boolean>> {
        isFirstTime = splashRepository.asLiveData()
        return isFirstTime
    }

    fun setAsFirstTime() {
        splashRepository.setAsFirstTime()
    }
}