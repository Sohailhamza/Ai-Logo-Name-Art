package com.example.ailogomaker.premium

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ailogomaker.R

class PremiumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium)


        ////////////////////////////////////////////////
        // Inside onCreate...
        val textView = findViewById<TextView>(R.id.tvHeader)
        val fullText = "Indulge in the full\nPremium collection"

        val spannable = SpannableString(fullText)

// Find where "Name Art" starts and ends
        val start = fullText.indexOf("Premium")
        val end = start + "Premium".length

// Apply the color #FF6CEB
        spannable.setSpan(
            ForegroundColorSpan("#FF6CEB".toColorInt()),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textView.text = spannable
        ///////////////////////////////////////////////////
    }
}