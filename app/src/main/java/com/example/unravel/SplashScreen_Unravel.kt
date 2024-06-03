package com.example.unravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen_Unravel : AppCompatActivity() {
    private val splashScreenTime: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_unravel)
        android.os.Handler().postDelayed({
            startActivity(Intent(this, LogInActivity:: class.java))
            finish()
        }, splashScreenTime)
    }
}