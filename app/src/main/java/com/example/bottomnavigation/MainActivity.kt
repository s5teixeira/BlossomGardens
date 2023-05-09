package com.example.bottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

//class MainActivity : AppCompatActivity(), View.OnClickListener {
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    @SuppressLint("MissingInflatedId")
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
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // This is for changing text on the top of the screen <-- called "app bar"
        // setOf() is Kotlin "set" (Data structure)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_tickets,
                R.id.nav_offers,
                R.id.nav_rewards
            )
        )

        // This set up the "app bar" with the navigation graph
        // Whenever user click bottom menu, text changes ("app bar")
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)

        // when user click bottom menu, each fragment's xml shows in the middle
        // nav_view is from activity_main.xml
        findViewById<BottomNavigationView>(R.id.nav_view)?.setupWithNavController(navHostFragment.navController)

//        val button1 = findViewById<Button>(R.id.button_thing)
//        button1.setOnClickListener {
//            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
//        }


//        val petunia_seeds = findViewById<Button>(R.id.button12) as Button
//        petunia_seeds.setOnClickListener {
////            Toast.makeText(CartFragment, "button clicked.", Toast.LENGTH_SHORT).show()
//            findViewById<TextView>(R.id.textView5).text = "petunia seeds clicked."
//
//        }
//        findViewById<Button>(R.id.button12)
//            RewardsFragment.setOnClickListener {
//                Log.d("BUTTONS", "User tapped the petunia button")
//            }
//        var button12 = Button(this)
//        View.addView(button12)
//        MainActivity.globalMessage.add("Hello") //    ADDS TO SHOPPING CART *************
    }

//    fun petunia_seeds_clicked(view: View) {
//        findViewById<TextView>(R.id.textView5).text = "petunia seeds added to cart."
//    }

//    findViewById<Button>(R.id.button12)
//            .setOnClickListener {
//                Log.d("BUTTONS", "User tapped the petunia button")
//            }
//        findViewById<TextView>(R.id.@com.example.bottomnavigation/fragment_cart.xml).text = "test textview."


    // Add the "overflow menu" (cart and settings) to the "app bar"
    // show a menu from the "menu/main.xml"
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // Handles the "up button"(<--)" Not a back button, goes back to its parent
    // It always goes to "home"
    // app:startDestination="@+id/nav_home" from mobile_navigation.xml
    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)

    // handles what to do when the item is selected from "app bar"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
    }

    companion object {
        var globalMessage: MutableList<String> = ArrayList()
    }

    fun sendToShoppingCart(view: View) {
        Log.d("Shopping Cart", "button clicked, item added to cart")
        MainActivity.globalMessage.add((view as Button).text.toString())
        Toast.makeText(this@MainActivity, "Added to Cart!", Toast.LENGTH_SHORT).show()

    }




//    var incrementingValue = 1 // Initialize the incrementing value to 1
//
//    fun sendToShoppingCart2(view: View) {
//        Log.d("Shopping Cart", "button clicked, item added to cart")
//        val buttonText = (view as Button).text.toString()
//        val message = "$buttonText x $incrementingValue" // Add the incrementing value to the message
//        MainActivity.globalMessage.add(message)
//        Toast.makeText(this@MainActivity, "Added to Cart!", Toast.LENGTH_SHORT).show()
//    }

    // Add a click listener to the incrementing button to update its value
//    val incrementingButton = findViewById<Button>(R.id.incrementingButton) as Button2
//    incrementingButton.setOnClickListener {
//        incrementingValue++
//    }
}