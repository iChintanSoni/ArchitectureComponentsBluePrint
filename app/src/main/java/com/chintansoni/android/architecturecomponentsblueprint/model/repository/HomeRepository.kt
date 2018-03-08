package com.chintansoni.android.architecturecomponentsblueprint.model.repository

import android.arch.lifecycle.MediatorLiveData
import com.chintansoni.android.architecturecomponentsblueprint.model.Resource
import com.chintansoni.android.architecturecomponentsblueprint.model.preference.FirstTimePreference
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by yashsoni on 02/03/18.
 */
@Singleton
class HomeRepository @Inject constructor(private var firstTimePreference: FirstTimePreference) {

    private val result = MediatorLiveData<Resource<Boolean>>()

    init {
        result.value = Resource.loading()
    }
}