package com.example.ailogomaker

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ailogomaker.mainscreen.graphicslogo.LogoViewModel
import com.google.android.material.card.MaterialCardView
import androidx.core.graphics.toColorInt

class StyleFragment : Fragment(R.layout.fragment_style) {

    private val viewModel: LogoViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardAbstract = view.findViewById<MaterialCardView>(R.id.cardAbstract)
        val btnContinue = view.findViewById<Button>(R.id.btnContinue)

        cardAbstract.setOnClickListener {
            viewModel.selectedStyle.value = "Abstract"

            updateStyleSelection(cardAbstract)

            btnContinue.isEnabled = true
            btnContinue.alpha = 1.0f
        }

        btnContinue.setOnClickListener {
            findNavController().navigate(R.id.toColor)
        }
    }

    // Iska naam consistent rakhein
    private fun updateStyleSelection(selectedCard: MaterialCardView) {
        val neonColor = "#00F2FF".toColorInt()
        selectedCard.strokeColor = neonColor
        selectedCard.strokeWidth = 6
    }
}