package com.example.bottomnavigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Note that bottom menu and fragments are separated containers.
        We need a controller to manipulate fragment whenever menu is clicked.
        So, we need to retrieve the "NavHostFragment", which is the content area
            android:name="androidx.navigation.fragment.NavHostFragment" (activity_main.xml)
        supportFragmentManager: Return the FragmentManager for interacting with fragments associated with this activity.
        supportFragmentManager.findFragmentByID() is a getter, getting "nav_host_fragment" (activity_main.xml) "as" means type casting
        */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // This is for changing text on the top of the screen <-- called "app bar"
        // setOf() is Kotlin "set" (Data structure)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_tickets, R.id.nav_offers, R.id.nav_rewards))

        // This set up the "app bar" with the navigation graph
        // Whenever user click bottom menu, text changes ("app bar")
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)

        // when user click bottom menu, each fragment's xml shows in the middle
        // nav_view is from activity_main.xml
        findViewById<BottomNavigationView>(R.id.nav_view)?.setupWithNavController(navHostFragment.navController)

//        val button1 = findViewById(R.id.button1) as Button
//        button1.setOnClickListener {
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
//        }

    }

    // Add the "overflow menu" (cart and settings) to the "app bar"
    // show a menu from the "menu/main.xml"
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // Handles the "up button"(<--)" Not a back button, goes back to its parent
    // It always goes to "home"
    // app:startDestination="@+id/nav_home" from mobile_navigation.xml
    override fun onSupportNavigateUp():Boolean = findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)

    // handles what to do when the item is selected from "app bar"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
    }
}