package com.chintansoni.android.architecturecomponentsblueprint.viewmodel.fragmentviewmodel

import android.arch.lifecycle.LiveData
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseViewModel
import com.chintansoni.android.architecturecomponentsblueprint.model.Resource
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiResponse
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiService
import com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response.RandomUserResponse
import javax.inject.Inject

/**
 * Created by chint on 3/8/2018.
 */
class NetworkCallFragmentViewModel() : BaseViewModel() {

    private lateinit var liveDataUsers: LiveData<Resource<ApiResponse<RandomUserResponse>>>

    @Inject
    constructor(apiService: ApiService) : this() {
        liveDataUsers = apiService.getUser("10")
    }

    fun getLiveDataUsers(): LiveData<Resource<ApiResponse<RandomUserResponse>>> {
        return liveDataUsers
    }
}