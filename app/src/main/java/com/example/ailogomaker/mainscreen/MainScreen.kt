package com.example.ailogomaker.mainscreen

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ailogomaker.R
import com.example.ailogomaker.favourites.FavouriteActivity
import com.example.ailogomaker.premium.PremiumActivity
import com.example.ailogomaker.setting.SettingsActivity
import androidx.core.graphics.toColorInt

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        val imgSetting = findViewById<ImageView>(R.id.imgSetting)

        ////////////////////////////////////////////////
        // Inside onCreate...
        val textView = findViewById<TextView>(R.id.tvHeader)
        val fullText = "Ai Logo\n& Name Art"

        val spannable = SpannableString(fullText)

// Find where "Name Art" starts and ends
        val start = fullText.indexOf("Name Art")
        val end = start + "Name Art".length

// Apply the color #FF6CEB
        spannable.setSpan(
            ForegroundColorSpan("#FF6CEB".toColorInt()),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textView.text = spannable
        ///////////////////////////////////////////////////

        imgSetting.setOnClickListener {

            Toast.makeText(this, "Settings Opened!", Toast.LENGTH_SHORT).show()
             val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val layPremium = findViewById<LinearLayout>(R.id.layPremium)
        layPremium.setOnClickListener {
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)
        }


        val imgFav = findViewById<ImageView>(R.id.imgFav)
        imgFav.setOnClickListener {
            val intent = Intent(this, FavouriteActivity::class.java)
            startActivity(intent)
        }

        // 1. View ko find
        val btnAiLogo = findViewById<LinearLayout>(R.id.btnAiLogo)

        // 2. Click Listener
        btnAiLogo.setOnClickListener {
            val intent = Intent(this, AiLogoActivity::class.java)
            startActivity(intent)
        }

    }
}