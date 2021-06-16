package com.example.mvvmarvel.core.navigation

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvmarvel.R
import com.example.mvvmarvel.databinding.NavigationActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: NavigationActivityBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavigationActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initListeners()
    }

    private fun initView() {
        supportActionBar?.elevation = 0f
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.container.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.toolbar.visibility = when (destination.id) {
                R.id.charactersFragment -> View.VISIBLE
                else -> View.GONE
            }
        }
    }
}

