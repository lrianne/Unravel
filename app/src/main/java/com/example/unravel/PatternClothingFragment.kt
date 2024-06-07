package com.example.unravel

import android.content.Context
import android.content.Intent
import android.net.Uri
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

        val intent = Intent(activity, CrochetPatternActivity::class.java)

        binding.proj1Title.setOnClickListener{
            val url = resources.getString(R.string.crochet_vNeck_vest_link)
            openPatternLink(url)
        }

        binding.proj2Title.setOnClickListener{
            val url = resources.getString(R.string.crochet_crew_neck_cardigan_link)
            openPatternLink(url)
        }

        binding.proj3Title.setOnClickListener{
            val url = resources.getString(R.string.cowl_neck_pullover_link)
            openPatternLink(url)
        }

        binding.proj4Title.setOnClickListener{
            val url = resources.getString(R.string.crochet_baby_jacket_set_link)
            openPatternLink(url)
        }

        binding.proj5Title.setOnClickListener{
            startActivity(intent)
            createClothesPatternPage("clothesFive")
        }
        return binding.root
    }

    /*Saves the user's chosen pattern.*/
    private fun createClothesPatternPage(string: String){
        val sharedPreferences = activity?.getSharedPreferences("user_pattern", Context.MODE_PRIVATE)
        val patternChosen = sharedPreferences?.edit()

        patternChosen?.putString("pattern", string)
        patternChosen?.apply()
    }

    /*Redirects the user to the actual website page of the pattern.*/
    private fun openPatternLink(string: String){
        val openLink = Intent();
        openLink.setAction(Intent.ACTION_VIEW)
        openLink.addCategory(Intent.CATEGORY_BROWSABLE)
        openLink.setData(Uri.parse(string))
        startActivity(openLink)
    }

}