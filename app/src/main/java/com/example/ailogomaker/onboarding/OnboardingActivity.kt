package com.example.ailogomaker.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.ailogomaker.R
import com.example.ailogomaker.mainscreen.MainScreen


class OnboardingActivity : AppCompatActivity() {

    private lateinit var adapter: OnboardingAdapter
    private val onboardingList = listOf(
        OnboardingModel(R.drawable.onboarding1, "AI Logo & Name Art", "Your All in one studio to create stunning\nbrand identities."),
        OnboardingModel(R.drawable.onboarding2, "Powerful Features", "Everything you need to create\nprofessional designs."),
        OnboardingModel(R.drawable.onboarding3rd, "Personalize Your Experience", "Tell us what you want to create and get\nyour designs ready.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val dotsLayout = findViewById<LinearLayout>(R.id.dotsLayout)
        val btnNext = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnNext)

        adapter = OnboardingAdapter(onboardingList)
        viewPager.adapter = adapter

        setupDots(onboardingList.size, dotsLayout)
        setCurrentDot(0, dotsLayout)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentDot(position, dotsLayout)
            }
        })

        btnNext.setOnClickListener {
            if (viewPager.currentItem + 1 < onboardingList.size) {
                viewPager.currentItem += 1
            } else {
                // Finish Onboarding
                startActivity(Intent(this, MainScreen::class.java))
            }
        }
    }

    private fun setupDots(size: Int, layout: LinearLayout) {
        val dots = arrayOfNulls<ImageView>(size)
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(8, 0, 8, 0)

        for (i in dots.indices) {
            dots[i] = ImageView(applicationContext)
            dots[i]?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_inactive))
            dots[i]?.layoutParams = params
            layout.addView(dots[i])
        }
    }

    private fun setCurrentDot(index: Int, layout: LinearLayout) {
        val childCount = layout.childCount
        for (i in 0 until childCount) {
            val imageView = layout.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_active))
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_inactive))
            }
        }
    }
}