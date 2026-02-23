package com.example.ailogomaker.mainscreen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ailogomaker.PromptFragment
import com.example.ailogomaker.R

class AiLogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ai_logo)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val cardGraphic = findViewById<LinearLayout>(R.id.cardGraphicLogo)
        val cardText = findViewById<LinearLayout>(R.id.cardTextLogo)
        val cardLogoToLogo = findViewById<LinearLayout>(R.id.cardLogoToLogo)
        val cardUpscale = findViewById<LinearLayout>(R.id.cardUpscaleLogo)

        // Back Button Logic
        btnBack.setOnClickListener {
            finish()
        }

        // 4. Graphic Logo Click
        cardGraphic.setOnClickListener {
            Toast.makeText(this, "Transaction Starting...", Toast.LENGTH_SHORT).show()

            val promptFragment = PromptFragment()
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fragment_container_ai, promptFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        cardText.setOnClickListener {
            Toast.makeText(this, "Text Logo Clicked", Toast.LENGTH_SHORT).show()
        }

        cardLogoToLogo.setOnClickListener {
            Toast.makeText(this, "Logo to Logo Clicked", Toast.LENGTH_SHORT).show()
        }

        cardUpscale.setOnClickListener {
            Toast.makeText(this, "Upscale Logo Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}