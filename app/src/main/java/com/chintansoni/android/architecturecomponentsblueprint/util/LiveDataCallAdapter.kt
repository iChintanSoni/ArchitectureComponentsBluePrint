package com.chintansoni.android.architecturecomponentsblueprint.util

import android.arch.lifecycle.LiveData
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean


/**
 * Created by chint on 2/21/2018.
 */
class LiveDataCallAdapter<R>(responseType: Type) : CallAdapter<R, LiveData<ApiResponse<R>>> {

    private val mResponseType: Type? = responseType

    override fun responseType(): Type? {
        return mResponseType
    }

    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {
            internal var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            postValue(ApiResponse(response))
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            postValue(ApiResponse(throwable))
                        }
                    })
                }
            }
        }
    }
}