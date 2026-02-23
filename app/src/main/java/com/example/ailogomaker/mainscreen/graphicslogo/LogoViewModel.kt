package com.example.ailogomaker.mainscreen.graphicslogo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogoViewModel : ViewModel() {
    // Step 1 Data
    val promptText = MutableLiveData<String>("")

    // Step 2 Data
    val selectedStyle = MutableLiveData<String>("")

    // Step 3 Data
    val selectedColorPalette = MutableLiveData<List<Int>>() // Colors as Hex/Int

    // Reset data if needed
    fun resetData() {
        promptText.value = ""
        selectedStyle.value = ""
        selectedColorPalette.value = emptyList()
    }
}