package edu.msudenver.cs3013.project1_s24

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navigation_view)
        bottomNavView = findViewById(R.id.bottom_nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController, drawerLayout)
        navView.setupWithNavController(navController)
        bottomNavView.setupWithNavController(navController)

        //This implementation of setNavigationItemSelectedListener allows proper navigation to the correct fragment
        //the log shows what item menu is clicked
        navView.setNavigationItemSelectedListener { menuItem ->
            Log.d("MainActivity", "Menu item clicked: ${menuItem.title}")
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.homeFragment)
                }
                R.id.nav_profile -> {
                    navController.navigate(R.id.profileFragment)
                }
                R.id.nav_notifications -> {
                    navController.navigate(R.id.notificationFragment)
                }
                R.id.nav_settings -> {
                    navController.navigate(R.id.settingsFragment)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        //this should allow the bottom nav buttons to go to the correct fragment
        bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            Log.d("MainActivity", "Bottom nav item clicked: ${menuItem.title}")
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.homeFragment)
                }
                R.id.navigation_tasks -> {
                    navController.navigate(R.id.taskListFragment)
                }
                R.id.navigation_music -> {
                    navController.navigate(R.id.musicPlayerFragment)
                }
            }
            true
        }
        //allows us to see the activity of the drawer
        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Log.d("MainActivity", "Drawer sliding")
            }

            override fun onDrawerOpened(drawerView: View) {
                Log.d("MainActivity", "Drawer opened")
            }

            override fun onDrawerClosed(drawerView: View) {
                Log.d("MainActivity", "Drawer closed")
            }

            override fun onDrawerStateChanged(newState: Int) {
                Log.d("MainActivity", "Drawer state changed: $newState")
            }
        })

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    if (!navController.navigateUp()) {
                        finish()
                    }
                }
            }
        })
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }
    //allows the drawer to be opened properly
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Log.d("MainActivity", "Drawer toggle clicked")
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

