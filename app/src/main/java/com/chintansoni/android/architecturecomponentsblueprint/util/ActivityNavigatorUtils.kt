package com.chintansoni.android.architecturecomponentsblueprint.util

import android.content.Intent
import android.support.v7.app.AppCompatActivity

/**
 * Created by chint on 2/18/2018.
 */
object ActivityNavigatorUtils {

    private const val DEFAULT_REQUEST_CODE = 100

    fun launchActivity(appCompatActivity: AppCompatActivity, intent: Intent) {
        launchActivity(appCompatActivity, intent, false)
    }

    fun launchActivity(appCompatActivity: AppCompatActivity, intent: Intent, finishCurrent: Boolean) {
        launchActivity(appCompatActivity, intent, DEFAULT_REQUEST_CODE, finishCurrent)
    }

    fun launchActivity(appCompatActivity: AppCompatActivity, intent: Intent, requestCode: Int) {
        launchActivity(appCompatActivity, intent, requestCode, false)
    }

    fun launchActivity(appCompatActivity: AppCompatActivity, intent: Intent, requestCode: Int, finishCurrent: Boolean) {
        if (requestCode != DEFAULT_REQUEST_CODE) {
            appCompatActivity.startActivityForResult(intent, requestCode)
        } else {
            if (finishCurrent) {
                appCompatActivity.finish()
            }
            appCompatActivity.startActivity(intent)
        }
    }
}