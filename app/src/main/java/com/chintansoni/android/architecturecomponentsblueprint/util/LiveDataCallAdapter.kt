package com.chintansoni.android.architecturecomponentsblueprint.util

import android.arch.lifecycle.LiveData
import com.chintansoni.android.architecturecomponentsblueprint.model.Resource
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.lang.reflect.Type


/**
 * Created by chint on 2/21/2018.
 */
class LiveDataCallAdapter<R>(responseType: Type) : CallAdapter<R, LiveData<Resource<ApiResponse<R>>>> {

    private val mResponseType: Type? = responseType

    override fun responseType(): Type? {
        return mResponseType
    }

    override fun adapt(call: Call<R>): LiveData<Resource<ApiResponse<R>>> {
        return object : LiveData<Resource<ApiResponse<R>>>() {
            override fun onActive() {
                super.onActive()
                postValue(Resource.loading())
                call.enqueue(object : Callback<R> {
                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        postValue(Resource.success(ApiResponse(response)))
                    }

                    override fun onFailure(call: Call<R>, throwable: Throwable) {
                        postValue(Resource.error(Exception(throwable), null))
                    }
                })
            }
        }
    }
}