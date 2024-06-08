package com.example.unravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.unravel.databinding.FragmentCategoryBinding
import com.google.android.material.tabs.TabLayoutMediator

class CategoryFragment : Fragment() {

    private var categoryBinding: FragmentCategoryBinding? = null

    private val binding get() = categoryBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        categoryBinding = FragmentCategoryBinding.inflate(inflater,container,false)

        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(PatternAmigurumiFragment(), "Amigurumi")
        adapter.addFragment(PatternClothingFragment(), "Clothing")

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

        return binding.root
    }
}

// Displays the Amigurumi and Clothing fragments in the View Pager.
class ViewPagerAdapter(fragmentActivity: CategoryFragment) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = ArrayList<Fragment>()
    private val fragmentTitles = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String){
        fragments.add(fragment)
        fragmentTitles.add(title)
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getPageTitle(position: Int): String = fragmentTitles[position]
}