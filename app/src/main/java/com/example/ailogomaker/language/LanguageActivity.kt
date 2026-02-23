package com.example.ailogomaker.language

import LanguageAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ailogomaker.R
import com.example.ailogomaker.onboarding.OnboardingActivity

class LanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val rvLanguages = findViewById<RecyclerView>(R.id.rvLanguages)

        // Sample Data
        val languages = listOf(
            LanguageModel("German", R.drawable.flag_germany),
            LanguageModel("French", R.drawable.flag_france),
            LanguageModel("English", R.drawable.flag_uk),
            LanguageModel("Dutch", R.drawable.flag_netherlands),
            LanguageModel("Spanish", R.drawable.flag_spain),
            LanguageModel("Hindi", R.drawable.flag_india),
            LanguageModel("Portuguese", R.drawable.flag_portugal)
        )

        val adapter = LanguageAdapter(languages)
        rvLanguages.layoutManager = LinearLayoutManager(this)
        rvLanguages.adapter = adapter

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }
    }
}