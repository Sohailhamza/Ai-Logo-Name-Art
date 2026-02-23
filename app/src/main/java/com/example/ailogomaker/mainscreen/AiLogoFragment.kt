package com.example.ailogomaker.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ailogomaker.PromptFragment
import com.example.ailogomaker.R

class AiLogoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Layout inflate karna
        val view = inflater.inflate(R.layout.fragment_ai_logo, container, false)

        // Views ko initialize karna
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)
        val cardGraphic = view.findViewById<LinearLayout>(R.id.cardGraphicLogo)
        val cardText = view.findViewById<LinearLayout>(R.id.cardTextLogo)
        val cardLogoToLogo = view.findViewById<LinearLayout>(R.id.cardLogoToLogo)
        val cardUpscale = view.findViewById<LinearLayout>(R.id.cardUpscaleLogo)

        // 1. Back Button Click
        btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        // 2. Graphic Logo Click
        cardGraphic.setOnClickListener {
            val promptFragment = PromptFragment()

            val transaction = parentFragmentManager.beginTransaction()

            transaction.setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )

            transaction.replace(R.id.fragment_container, promptFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // 3. Text Logo Click
        cardText.setOnClickListener {
            Toast.makeText(context, "Text Logo Clicked", Toast.LENGTH_SHORT).show()
        }

        // 4. Logo to Logo Click
        cardLogoToLogo.setOnClickListener {
            Toast.makeText(context, "Logo to Logo Clicked", Toast.LENGTH_SHORT).show()
        }

        // 5. Upscale Logo Click
        cardUpscale.setOnClickListener {
            Toast.makeText(context, "Upscale Logo Clicked", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}