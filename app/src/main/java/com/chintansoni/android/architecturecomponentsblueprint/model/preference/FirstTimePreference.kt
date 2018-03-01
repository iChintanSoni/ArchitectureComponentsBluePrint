package com.chintansoni.android.architecturecomponentsblueprint.model.preference

import android.app.Application
import com.chintansoni.android.architecturecomponentsblueprint.util.SharedPrefsUtils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by chint on 2/18/2018.
 */

@Singleton
class FirstTimePreference @Inject constructor(private var application: Application) {

    private val preferenceFirstTime = "FirstTime"

    fun isFirstTimePreference(): Boolean {
        return SharedPrefsUtils.getBooleanPreference(application, preferenceFirstTime, true)
    }

    fun setFirstTimePreference() {
        return SharedPrefsUtils.setBooleanPreference(application, preferenceFirstTime, false)
    }
}