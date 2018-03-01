package com.chintansoni.android.architecturecomponentsblueprint.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseDrawerActivity

class HomeActivity : BaseDrawerActivity() {

    companion object {

        fun getActivityIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getMenuResource(): Int {
        return R.menu.home
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
