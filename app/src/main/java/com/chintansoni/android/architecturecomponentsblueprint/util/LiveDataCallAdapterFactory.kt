package com.chintansoni.android.architecturecomponentsblueprint.util

import android.arch.lifecycle.LiveData
import com.chintansoni.android.architecturecomponentsblueprint.model.Resource
import com.chintansoni.android.architecturecomponentsblueprint.model.api.ApiResponse
import com.google.gson.internal.`$Gson$Types`.getRawType
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/**
 * Created by chint on 2/21/2018.
 */
class LiveDataCallAdapterFactory : CallAdapter.Factory() {
    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {

        // Check If return Type is of LiveData
        if (getRawType(returnType) != LiveData::class.java) {
            return null
        }

        // Check if LiveData is of Type Resource
        val observableTypeResource = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObservableTypeResource = getRawType(observableTypeResource)
        if (rawObservableTypeResource != Resource::class.java) throw IllegalArgumentException("type must be a Resource")
        if (observableTypeResource !is ParameterizedType) throw IllegalArgumentException("Resource must be parametrised")

        // Check if Resource is of Type ApiResponse
        val observableTypeApiResponse = getParameterUpperBound(0, observableTypeResource)
        val rawObservableTypeApiResponse = getRawType(observableTypeApiResponse)
        if (rawObservableTypeApiResponse != ApiResponse::class.java) throw IllegalArgumentException("type must be a ApiResponse")
        if (observableTypeApiResponse !is ParameterizedType) throw IllegalArgumentException("ApiResponse must be parametrised")


        // Get Type of ApiResponse
        val bodyType = getParameterUpperBound(0, observableTypeApiResponse)
        return LiveDataCallAdapter<Any>(bodyType)
    }
}