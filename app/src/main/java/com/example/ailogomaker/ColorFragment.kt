package com.example.ailogomaker

import android.content.res.ColorStateList
import android.graphics.Color // Correct Import
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ailogomaker.mainscreen.graphicslogo.LogoViewModel
import com.google.android.material.card.MaterialCardView
import androidx.core.graphics.toColorInt

class ColorFragment : Fragment(R.layout.fragment_color) {

    private val viewModel: LogoViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Palette click logic
        val paletteRed = view.findViewById<MaterialCardView>(R.id.paletteRed)
        paletteRed.setOnClickListener {
            viewModel.selectedColorPalette.value = listOf(
                0xFF4A0000.toInt(),
                0xFF8B0000.toInt(),
                0xFFFF0000.toInt(),
                0xFFFF4D4D.toInt()
            )

            updatePaletteSelection(paletteRed)
        }

        val btnGenerate = view.findViewById<Button>(R.id.btnGenerate)
        btnGenerate.setOnClickListener {
            findNavController().navigate(R.id.toLoading)
        }
    }

    private fun updatePaletteSelection(selectedCard: MaterialCardView) {
        // Option 1: Direct Color Int use karein (Recommended)
        val neonColor = "#00F2FF".toColorInt()
        selectedCard.strokeColor = neonColor // Ab mismatch nahi hoga
        selectedCard.strokeWidth = 6

        // Option 2: Agar aapko ColorStateList hi use karni hai, toh property change karein:
        // selectedCard.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#00F2FF")))
    }
}