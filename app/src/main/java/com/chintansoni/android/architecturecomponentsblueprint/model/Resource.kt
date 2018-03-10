package com.chintansoni.android.architecturecomponentsblueprint.model

import java.lang.Exception

/**
 * Created by chintan.soni on 23/02/18.
 */
class Resource<out T>(val status: Status, val data: T?, val exception: Exception?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: Exception?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, exception)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }
    }

    override fun toString(): String {
        return "Resource(status=$status, data=$data, exception=$exception)"
    }
}
