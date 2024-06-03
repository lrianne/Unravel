package com.example.unravel

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.unravel.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var exploreBinding: FragmentExploreBinding? = null
    private val binding get() = exploreBinding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        exploreBinding = FragmentExploreBinding.inflate(inflater,container, false)

        val sharedPreferences = requireActivity().applicationContext.getSharedPreferences("user_prefers", Context.MODE_PRIVATE)
        val givenName = sharedPreferences.getString("name", "")
        binding.userName.text = givenName

        return binding.root
    }
}