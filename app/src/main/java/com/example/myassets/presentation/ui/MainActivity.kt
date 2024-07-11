package com.example.myassets.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.myassets.R
import com.example.myassets.databinding.ActivityMainBinding
import com.example.myassets.presentation.ui.home.HomeFragmentDirections

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_holder) as NavHostFragment
        val navController = navHostFragment.navController

        binding.navigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_bar_home -> navController.popBackStack()
                R.id.nav_bar_portfolios -> navController.navigate(
                    HomeFragmentDirections.actionHomeFragmentToPortfolioListFragment()
                )

                R.id.nav_bar_assets -> navController.navigate(
                    HomeFragmentDirections.actionHomeFragmentToAssetListFragment()
                )

                R.id.nav_bar_settings -> navController.navigate(
                    HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
                )

                else -> {}
            }
            true
        }
    }
}
