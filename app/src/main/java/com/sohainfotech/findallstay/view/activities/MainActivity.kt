package com.sohainfotech.findallstay.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sohainfotech.findallstay.R
import com.sohainfotech.findallstay.databinding.ActivityMainBinding
import com.sohainfotech.findallstay.view.fragments.*

class MainActivity : AppCompatActivity() {
    //to use DataBinding
    private lateinit var binding: ActivityMainBinding

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to use DataBinding
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding

        /*toolbar = findViewById(R.id.toolbar_main)
        toolbarText = findViewById(R.id.toolbarTextMain)
        toolbar.title = resources.getString(R.string.app_name)
        setSupportActionBar(toolbar)*/
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarMain.title = resources.getString(R.string.app_name)
        setSupportActionBar(binding.toolbarMain)

        val homeFragment = HomeFragment()
        val wishListFragment = WishListFragment()
        val addStayFragment = AddStayFragment()
        val loginFragment = SignInFragment()

        setCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.home_menu -> setCurrentFragment(homeFragment)
                R.id.wish_list_menu -> setCurrentFragment(wishListFragment)
                R.id.add_menu -> setCurrentFragment(addStayFragment)
                R.id.login_menu -> setCurrentFragment(loginFragment)

            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

   // override fun onBackPressed() {
       /* SignInFragment.counter = 0
        SignUpFragment.counter = 0
        super.onBackPressed()*/

       /* if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
            Log.d("TAG", "onBackPressed: ")
        } else{
            SignInFragment.counter = 0
            SignUpFragment.counter = 0
            super.onBackPressed()
        }*/
/*
        val fragmentsInStack = supportFragmentManager.backStackEntryCount
        if (fragmentsInStack > 1) { // If we have more than one fragment, pop back stack
            supportFragmentManager.popBackStack()
        } else if (fragmentsInStack == 1) { // Finish activity, if only one fragment left, to prevent leaving empty screen
            finish()
        } else {
            super.onBackPressed()
        }*/
   // }

}