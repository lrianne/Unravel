package com.example.unravel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import com.example.unravel.databinding.FragmentPatternAmigurumiBinding

class PatternAmigurumiFragment : Fragment() {

    private var patternAmigurumiBinding: FragmentPatternAmigurumiBinding? = null
    private val binding get() = patternAmigurumiBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        patternAmigurumiBinding = FragmentPatternAmigurumiBinding.inflate(inflater, container, false)

        /*Redirects user to the generated Pattern Activity*/
        val intent = Intent(activity, CrochetPatternActivity::class.java)

        binding.proj1Title.setOnClickListener{
            startActivity(intent)
            createAmiPatternPage("amigurumiOne")
        }

        binding.proj2Title.setOnClickListener{
            startActivity(intent)
            createAmiPatternPage("amigurumiTwo")
        }

        binding.proj3Title.setOnClickListener{
            startActivity(intent)
            createAmiPatternPage("amigurumiThree")
        }

        return binding.root
    }

    /*Stores the user's chosen pattern.*/
    private fun createAmiPatternPage(string: String){
        val sharedPreferences = activity?.getSharedPreferences("user_pattern", Context.MODE_PRIVATE)
        val patternChosen = sharedPreferences?.edit()

        patternChosen?.putString("pattern", string)
        patternChosen?.apply()
    }
}