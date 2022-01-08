package me.hanhngo.homeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import me.hanhngo.homeps.databinding.ActivityMainBinding
import me.hanhngo.homeps.view.home.HomeFragmentDirections

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupBottomNavigation(binding, navController)
    }

    private fun setupBottomNavigation(
        binding: ActivityMainBinding,
        navController: NavController
    ) {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.add -> {
                    true
                }
                R.id.statistic -> {
                    navController.navigate(R.id.statisticFragment)
                    true
                }
                R.id.more -> {
                    true
                }
                else -> false
            }
        }
    }

}