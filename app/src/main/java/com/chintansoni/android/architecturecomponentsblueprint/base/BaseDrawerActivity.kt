package com.chintansoni.android.architecturecomponentsblueprint.base

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.chintansoni.android.architecturecomponentsblueprint.R
import com.chintansoni.android.architecturecomponentsblueprint.view.fragment.NetworkCallFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_appbar_toolbar.*

/**
 * Created by chint on 2/18/2018.
 */
abstract class BaseDrawerActivity : BaseToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    protected var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (fragment == null) {

        } else {
            replaceFragment(fragment!!, getContainerId())
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_network_call -> {
                fragment = NetworkCallFragment.getFragment()
                replaceFragment(fragment as NetworkCallFragment, getContainerId())
            }
            R.id.nav_network_database_call -> {

            }
            R.id.nav_database_call -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    abstract fun getContainerId(): Int
}