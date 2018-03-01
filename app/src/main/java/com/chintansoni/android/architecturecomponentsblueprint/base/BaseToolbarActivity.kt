package com.chintansoni.android.architecturecomponentsblueprint.base

import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.layout_appbar_toolbar.*

/**
 * Created by chint on 11/22/2017.
 */
abstract class BaseToolbarActivity : BaseActivity() {

    companion object {
        const val RES_NO_MENU = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (getMenuResource() != RES_NO_MENU)
            menuInflater.inflate(getMenuResource(), menu)
        return true
    }

    open fun getMenuResource(): Int {
        return RES_NO_MENU
    }
}
