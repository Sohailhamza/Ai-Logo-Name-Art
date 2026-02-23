package com.example.ailogomaker.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ailogomaker.language.LanguageActivity
import com.example.ailogomaker.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val btnGetStart = findViewById<Button>(R.id.btnGetStart)

        btnGetStart.setOnClickListener {

            val intent = Intent(this, LanguageActivity::class.java)
           startActivity(intent)
        }

    }
}