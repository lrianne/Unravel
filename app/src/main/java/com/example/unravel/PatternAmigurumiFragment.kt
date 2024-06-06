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
        val sharedPreferences = activity?.getSharedPreferences("user_pattern", Context.MODE_PRIVATE)
        val patternChosen = sharedPreferences?.edit()

        binding.proj1Title.setOnClickListener{
            val intent = Intent(activity, CrochetPatternActivity::class.java)
            startActivity(intent)
            if (patternChosen != null) {
                patternChosen.putString("pattern", "amigurumiOne")
            }
            if (patternChosen != null) {
                patternChosen.apply()
            }
        }

        return binding.root
    }
}
