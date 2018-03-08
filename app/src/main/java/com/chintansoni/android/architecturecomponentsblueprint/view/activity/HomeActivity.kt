package com.chintansoni.android.architecturecomponentsblueprint.view.activity

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.base.BaseDrawerActivity
import com.chintansoni.android.architecturecomponentsblueprint.viewmodel.activityviewmodel.HomeActivityViewModel
import javax.inject.Inject

class HomeActivity : BaseDrawerActivity() {

    override fun getContainerId(): Int = R.id.container_frame

    override fun getLayoutResource(): Int = R.layout.activity_home

    override fun getMenuResource(): Int = R.menu.home


    @Inject
    lateinit var homeActivityViewModel: HomeActivityViewModel

    companion object {
        fun getActivityIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
