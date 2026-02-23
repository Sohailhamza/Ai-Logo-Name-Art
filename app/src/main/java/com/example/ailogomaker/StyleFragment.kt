package com.example.ailogomaker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ailogomaker.mainscreen.graphicslogo.LogoViewModel
import com.google.android.material.card.MaterialCardView

class StyleFragment : Fragment(R.layout.fragment_style) {

    private val viewModel: LogoViewModel by activityViewModels()

    // Selected
    private var lastSelectedCard: MaterialCardView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Views initialization
        val cardMonogram = view.findViewById<MaterialCardView>(R.id.cardMonogram)
        val cardAbstract = view.findViewById<MaterialCardView>(R.id.cardAbstract)
        val card3D = view.findViewById<MaterialCardView>(R.id.card3D)
        val btnContinue = view.findViewById<Button>(R.id.btnContinue)
        val progressBar = view.findViewById<ProgressBar>(R.id.stepProgress)

        progressBar.progress = 66

        setupCardClick(cardMonogram, "Monogram", btnContinue)
        setupCardClick(cardAbstract, "Abstract", btnContinue)
        setupCardClick(card3D, "3D Logo", btnContinue)

        btnContinue.setOnClickListener {
            val colorFragment = ColorFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_ai, colorFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun setupCardClick(card: MaterialCardView, styleName: String, btn: Button) {
        card.setOnClickListener {

            lastSelectedCard?.strokeWidth = 2
            lastSelectedCard?.strokeColor = "#33FFFFFF".toColorInt()
            viewModel.selectedStyle.value = styleName

            updateStyleSelection(card)

            lastSelectedCard = card

            btn.isEnabled = true
            btn.alpha = 1.0f
        }
    }

    private fun updateStyleSelection(selectedCard: MaterialCardView) {
        val neonColor = "#00F2FF".toColorInt()
        selectedCard.strokeColor = neonColor
        selectedCard.strokeWidth = 6
    }
}