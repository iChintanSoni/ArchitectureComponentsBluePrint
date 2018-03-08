package com.chintansoni.android.architecturecomponentsblueprint.util

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by chint on 3/8/2018.
 */
object FragmentNavigationUtils {

    private const val FRAGMENT_TRANSACTION_ADD = 201
    private const val FRAGMENT_TRANSACTION_REPLACE = 202

    fun addFragment(appCompatActivity: AppCompatActivity, fragment: Fragment, containerId: Int) {
        addFragment(appCompatActivity, fragment, containerId, false)
    }

    fun addFragment(appCompatActivity: AppCompatActivity, fragment: Fragment, containerId: Int, addToBackStack: Boolean) {
        loadFragment(appCompatActivity, fragment, containerId, FRAGMENT_TRANSACTION_ADD, addToBackStack)
    }

    fun replaceFragment(appCompatActivity: AppCompatActivity, fragment: Fragment, containerId: Int) {
        replaceFragment(appCompatActivity, fragment, containerId, false)
    }

    fun replaceFragment(appCompatActivity: AppCompatActivity, fragment: Fragment, containerId: Int, addToBackStack: Boolean) {
        loadFragment(appCompatActivity, fragment, containerId, FRAGMENT_TRANSACTION_REPLACE, addToBackStack)
    }

    fun loadFragment(appCompatActivity: AppCompatActivity, fragment: Fragment, containerId: Int, transactionType: Int, addToBackStack: Boolean) {
        val fragmentName = fragment.javaClass.simpleName
        val fragmentTransaction = appCompatActivity.supportFragmentManager.beginTransaction()
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragmentName)
        }
        if (transactionType == FRAGMENT_TRANSACTION_ADD) {
            fragmentTransaction.add(containerId, fragment, fragmentName)
        } else {
            fragmentTransaction.replace(containerId, fragment, fragmentName)
        }
        fragmentTransaction.commit()
    }
}