package com.example.unravel

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.unravel.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.text.FieldPosition

private lateinit var bottomNavigation: BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigation = findViewById(R.id.navigation)

        bottomNavigation.setOnItemSelectedListener { navigationItem ->
        when(navigationItem.itemId) {
            R.id.explore_page -> {
                switchFragment(ExploreFragment())
                true
            }

            R.id.category_page -> {
                switchFragment(CategoryFragment())
                true
            }

            R.id.user_page -> {
                switchFragment(UserFragment())
                true
            }
            else -> false
        }
    }
    switchFragment(ExploreFragment())
    }

    //Switches between the three main fragments, and displays them on the Frame Layout of the Main Activity.
    private fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }
}
