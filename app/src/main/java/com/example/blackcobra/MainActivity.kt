package com.example.blackcobra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    // initialise the drawerlayout, navigationview and ToggleBar
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var actionBarToggle : ActionBarDrawerToggle
    private lateinit var navDrawerView : NavigationView

    // Initialise the NavigationBottomBar
    private lateinit var bottomNavigation : BottomNavigationView

    private fun setCurrentFragment(fragment:Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.FragmentContainer, fragment)
        commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // call findViewById on the DrawerLayout / panggil findViewById di DrawerLayout
        drawerLayout = findViewById(R.id.activity_main)

        // pass the ActionBarToggle action into the drawerListener / teruskan tindakan ActionBarToggle ke drawerListener
        actionBarToggle = ActionBarDrawerToggle(this,drawerLayout,0,0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer / Tampilkan ikon hamburger untuk meluncurkan laci
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // call syncState() on the action bar so it'll automatically change to the
        actionBarToggle.syncState()

        // call findViewById on the NavigationView / panggil findViewById di NavigationView
        navDrawerView = findViewById(R.id.navDrawer)

        // call setNavigationItemSelectedListener on the NavigationView to detect / panggil setNavigationItemSelectedListener di NavigationView untuk mendeteksi
        navDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myprofile -> {
                    Toast.makeText(this,"Go To My Profile",
                        Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.myemployee -> {
                    Toast.makeText(this,"Go To Our Employe",
                        Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.register -> {
                    val intent = Intent(applicationContext, register::class.java)
                    startActivity(intent)
                    true
                }
                else -> {
                    false
                }

            }
        }

        // call fragment from button navigation view /fragmen panggilan dari tampilan navigasi tombol
        val firstFragment = home()
        val secondFragment = song()
        val thirdFragment = album()
        val fourthFragment = artis()

        setCurrentFragment(firstFragment)
        bottomNavigation = findViewById(R.id.navButton)
        bottomNavigation.setOnNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.navigation_home    -> setCurrentFragment(firstFragment)
                R.id.navigation_songs   -> setCurrentFragment(secondFragment)
                R.id.navigation_album   -> setCurrentFragment(thirdFragment)
                R.id.navigation_artist  -> setCurrentFragment(fourthFragment)
            }
            true
        }



    }

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer((GravityCompat.START))
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    // Call infiate toolbar menu to Main Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    // Clicked item toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id) {
            R.id.toolbar_upright_Favorite -> {
                Toast.makeText(this, "Favorited!", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.toolbar_upright_Search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.toolbar_upright_Settings -> {
                Toast.makeText(this, "Go to Settings", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.toolbar_upright_LogOut -> {
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
        return super.onOptionsItemSelected(item)
    }

}