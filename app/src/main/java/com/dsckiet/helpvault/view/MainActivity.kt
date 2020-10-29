package com.dsckiet.helpvault.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private var currentInflatedFragment: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bottomNavigationView = binding.bottomNav
        navController = Navigation.findNavController(this, R.id.NavHostFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.icon_home -> {
                    when(currentInflatedFragment) {
                        0 -> false
                        1 -> {
                            navController.navigate(R.id.action_helpsFragment_to_homeFragment)
                            currentInflatedFragment = 0
                        }
                        2 -> {
                            navController.navigate(R.id.action_profileFragment_to_homeFragment)
                            currentInflatedFragment = 0
                        }
                    }
                    true
                }
                R.id.icon_helps -> {
                    when(currentInflatedFragment) {
                        0 -> {
                            navController.navigate(R.id.action_homeFragment_to_helpsFragment)
                            currentInflatedFragment = 1
                        }
                        1 -> false
                        2 -> {
                            navController.navigate(R.id.action_profileFragment_to_helpsFragment)
                            currentInflatedFragment = 1
                        }
                    }
                    true
                }
                R.id.icon_profile -> {
                    when (currentInflatedFragment) {
                        0 -> {
                            navController.navigate(R.id.action_homeFragment_to_profileFragment)
                            currentInflatedFragment = 2
                        }
                        1 -> {
                            navController.navigate(R.id.action_helpsFragment_to_profileFragment)
                            currentInflatedFragment = 2
                        }
                        2 -> false
                    }
                    true
                }
                else -> false
            }
        }
    }
}