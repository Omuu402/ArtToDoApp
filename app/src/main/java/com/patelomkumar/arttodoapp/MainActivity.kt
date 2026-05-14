package com.patelomkumar.arttodoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.patelomkumar.arttodoapp.databinding.ActivityMainBinding

/**
 * MainActivity — the single Activity that hosts all three fragments.
 *
 * Responsibilities:
 * 1. Inflate the root layout (CoordinatorLayout with Toolbar + NavHost + BottomNav)
 * 2. Set the Toolbar as the ActionBar
 * 3. Wire the NavController to both the Toolbar (for title updates) and the BottomNavigation
 *
 * All business logic lives in the ViewModel and fragments — this Activity stays thin.
 */
class MainActivity : AppCompatActivity() {

    // ViewBinding: type-safe reference to every view in activity_main.xml
    private lateinit var binding: ActivityMainBinding

    // NavController handles all fragment transactions
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Inflate layout using ViewBinding
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Register the custom Toolbar as the app's ActionBar
            setSupportActionBar(binding.toolbar)

            // Retrieve the NavController from the NavHostFragment
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHostFragment.navController

            /*
             * AppBarConfiguration tells the Navigation component which destinations
             * are "top-level" — meaning the Up (back) arrow will NOT appear for them.
             * Since all three tabs are top-level, we list all three here.
             */
            val appBarConfig = AppBarConfiguration(
                setOf(
                    R.id.nav_ongoing,
                    R.id.nav_upcoming,
                    R.id.nav_finished
                )
            )

            // Automatically update the Toolbar title when the user switches tabs
            setupActionBarWithNavController(navController, appBarConfig)

            // Standard setup for BottomNav — most stable way
            binding.bottomNav.setupWithNavController(navController)
            
        } catch (e: Exception) {
            e.printStackTrace()
            android.widget.Toast.makeText(this, "CRASH: ${e.message}", android.widget.Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Required for the Toolbar's Up button to work (navigates back in the nav graph).
     */
    override fun onSupportNavigateUp(): Boolean {
        return if (::navController.isInitialized) {
            navController.navigateUp() || super.onSupportNavigateUp()
        } else {
            super.onSupportNavigateUp()
        }
    }
}
