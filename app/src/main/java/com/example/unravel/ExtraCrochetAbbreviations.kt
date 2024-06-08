package com.example.unravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ExtraCrochetAbbreviations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra_crochet_abbreviations)
    }
    //Returns user to the Main Activity
    fun abbreviationsBackBtn(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}