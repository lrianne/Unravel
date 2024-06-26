package com.example.unravel

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.unravel.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private var userBinding: FragmentUserBinding? = null
    private val binding get() = userBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        userBinding = FragmentUserBinding.inflate(inflater,container, false)

        //Redirects the user to the Row Counter Activity
        binding.counterText.setOnClickListener{
            val intent = Intent(activity, RowCounterActivity::class.java)
            startActivity(intent)
        }
        //Redirects the user to the Instructions Activity
        binding.aboutUnravel.setOnClickListener{
            val intent = Intent(activity, Instructions::class.java)
            startActivity(intent)
        }
        //Redirects the user to the Crochet Hook Sizes Chart
        binding.hookSizes.setOnClickListener{
            val intent = Intent(activity, ExtraCrochetHook::class.java)
            startActivity(intent)
        }
        //Redirects the user to the list of Crochet Abbreviations
        binding.abbreviationsText.setOnClickListener{
            val intent = Intent(activity, ExtraCrochetAbbreviations::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}