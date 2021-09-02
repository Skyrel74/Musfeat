package com.example.musfeat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.musfeat.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

private lateinit var binding: ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private fun setIsNavBarVisible(isVisible: Boolean) {
        binding.bottomNavBar.isVisible = isVisible
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        val navController = navHost.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.signInFragment -> setIsNavBarVisible(false)
                R.id.signUpPersonalizationFragment -> setIsNavBarVisible(false)
                R.id.signUpFragment -> setIsNavBarVisible(false)
                R.id.restorePasswordFragment -> setIsNavBarVisible(false)
                else -> setIsNavBarVisible(true)
            }
        }
        binding.bottomNavBar.setupWithNavController(navController)
    }
}