package com.example.unravel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class CrochetPatternActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var displayPattern: TextView
    private lateinit var displayTitle: TextView
    private lateinit var displayImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crochet_pattern)

        sharedPreferences = getSharedPreferences("user_pattern", Context.MODE_PRIVATE)
        displayPattern = findViewById(R.id.showPattern)
        displayTitle = findViewById(R.id.patternTitle)
        displayImage = findViewById(R.id.patternOutcome)

        val amiPatternOne = resources.getString(R.string.crochet_jellyfish)
        var url = ""

        val patternChosen = sharedPreferences.getString("pattern", "")
        if (patternChosen == "amigurumiOne") {
            displayTitle.text = "Crochet Jellyfish"
            displayPattern.text = amiPatternOne
            displayImage.setImageResource(R.drawable.crochet_jellyfish_pin_1text)
            url = resources.getString(R.string.crochet_jellyfish_link)
        }

        if (patternChosen == "clothingOne") {
            displayTitle.text = "Crochet Jellyfish"
            displayPattern.text = amiPatternOne
            displayImage.setImageResource(R.drawable.crochet_jellyfish_pin_1text)
            url = resources.getString(R.string.crochet_jellyfish_link)
        }

        displayImage.setOnClickListener{
            intent = Intent();
            intent.setAction(Intent.ACTION_VIEW)
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }
    }
}