package com.example.unravel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class RowCounterActivity : AppCompatActivity() {

    private lateinit var savedCountBtn: Button
    private lateinit var displayCount: TextView
    private lateinit var sharedPreferences: SharedPreferences

    private var count = 0

    private lateinit var buttonPressed: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_row_counter)

        savedCountBtn = findViewById(R.id.showSavedButton)
        displayCount = findViewById(R.id.counterScreen)
        sharedPreferences = getSharedPreferences("user_count", Context.MODE_PRIVATE)

        val savedCount = sharedPreferences.getString("count", "")
        if (savedCount != "0"){
            savedCountBtn.visibility = View.VISIBLE
        }
    }

    fun backToMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun countIncrease (view: View){
        count ++
        displayCount.text = count.toString()
    }

    fun countDecrease (view: View){
        count --
        displayCount.text = count.toString()
    }

    fun countReset (view: View){
        count = 0
        displayCount.text = count.toString()
    }

    fun saveCount(view: View){
        val sharedPreferences = getSharedPreferences("user_count", Context.MODE_PRIVATE)
        val changeCount = sharedPreferences.edit()
        val countAsString = count.toString()
        changeCount.putString("count", countAsString)
        changeCount.apply()

        savedCountBtn.visibility = View.VISIBLE
    }

    fun showSavedCount(view: View){
        val sharedPreferences = getSharedPreferences("user_count", Context.MODE_PRIVATE)
        val savedCount = sharedPreferences.getString("count", "")
        if (savedCount != null) {
            count = savedCount.toInt()
        }
        displayCount.text = count.toString()
        savedCountBtn.visibility = View.GONE
    }
}