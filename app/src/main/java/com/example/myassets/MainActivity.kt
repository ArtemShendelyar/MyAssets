package com.example.myassets

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myassets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.navigationHolder.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_bar_home -> replaceFragment(HomeFragment())
                R.id.nav_bar_portfolios -> replaceFragment(PortfolioListFragment())
                R.id.nav_bar_assets -> replaceFragment(AssetsListFragment())
                R.id.nav_bar_settings -> replaceFragment(SettingsFragment())
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_holder,fragment)
        fragmentTransaction.commit()
    }
}