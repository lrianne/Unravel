package com.example.unravel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.unravel.R.*

class LogInActivity : AppCompatActivity() {

    private lateinit var userInput: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button
    private lateinit var startButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_log_in)

        // Initialize views
        userInput = findViewById(id.editText)
        saveButton = findViewById(id.saveButton)
        clearButton = findViewById(id.clearButton)
        startButton = findViewById(id.startButton)

        sharedPreferences = getSharedPreferences("user_prefers", Context.MODE_PRIVATE)

        saveButton.setOnClickListener {
            saveName()
            userInput.text.clear()
            val intent = Intent(this, Instructions::class.java)
            startActivity(intent)
        }

        startButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveName(){
        val name = userInput.text.toString()

        val sharedPreferences = getSharedPreferences("user_prefers", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.apply()
    }
}


