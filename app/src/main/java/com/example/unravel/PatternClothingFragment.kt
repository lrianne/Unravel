package com.example.unravel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.unravel.databinding.FragmentPatternAmigurumiBinding
import com.example.unravel.databinding.FragmentPatternClothingBinding

class PatternClothingFragment : Fragment() {

    private var patternClothingBinding: FragmentPatternClothingBinding? = null
    private val binding get() = patternClothingBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        patternClothingBinding = FragmentPatternClothingBinding.inflate(inflater, container, false)
        val sharedPreferences = activity?.getSharedPreferences("user_pattern", Context.MODE_PRIVATE)
        val patternChosen = sharedPreferences?.edit()

        binding.proj1Title.setOnClickListener{
            val intent = Intent(activity, CrochetPatternActivity::class.java)
            startActivity(intent)
            if (patternChosen != null) {
                patternChosen.putString("pattern", "clothingOne")
            }
            if (patternChosen != null) {
                patternChosen.apply()
            }
        }

        return binding.root
    }
}
