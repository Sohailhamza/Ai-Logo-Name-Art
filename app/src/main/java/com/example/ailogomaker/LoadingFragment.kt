package com.example.ailogomaker

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ailogomaker.mainscreen.graphicslogo.LogoViewModel

class LoadingFragment : Fragment(R.layout.fragment_loading) {
    private val viewModel: LogoViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) // super call miss na karein

        // 1. Get all data from ViewModel
        val finalPrompt = viewModel.promptText.value
        val finalStyle = viewModel.selectedStyle.value
        val finalColors = viewModel.selectedColorPalette.value

        // 2. Start animation/processing simulation
        startLogoGeneration(finalPrompt, finalStyle, finalColors)
    }

    private fun startLogoGeneration(prompt: String?, style: String?, colors: List<Int>?) {
        // Yahan aap real API call (Retrofit) laga sakte hain.
        // Filhal hum 4 seconds ka delay dete hain
        Handler(Looper.getMainLooper()).postDelayed({

            // Navigate to Result Fragment (Jahan generated logo dikhega)
            // findNavController().navigate(R.id.action_loading_to_result)

        }, 4000) // 4000ms = 4 seconds
    }
}