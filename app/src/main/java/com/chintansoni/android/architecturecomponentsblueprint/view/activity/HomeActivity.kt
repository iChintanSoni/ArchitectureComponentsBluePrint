package com.chintansoni.android.architecturecomponentsblueprint.view.activity

import android.content.Context
import android.content.Intent
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

    override fun getMenuResource(): Int {
        return R.menu.home
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
