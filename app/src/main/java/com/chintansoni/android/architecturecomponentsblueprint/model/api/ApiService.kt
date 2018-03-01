package com.chintansoni.android.architecturecomponentsblueprint.model.api

import android.arch.lifecycle.LiveData
import com.chintansoni.android.architecturecomponentsblueprint.model.api.getusers.response.RandomUserResponse
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by chint on 2/21/2018.
 */
interface ApiService {

    @GET("api/")
    fun getUser(@Query("results") sort: String): LiveData<ApiResponse<RandomUserResponse>>

}