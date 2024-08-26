package com.example.trademate.ui.Class

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GradientViewModel : ViewModel() {

    var fallState by mutableStateOf("")
    var gradientState by mutableStateOf("")
    var lengthState by mutableStateOf("")
    var percentageState by mutableStateOf("")

    fun calculate() {
        val fall = fallState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val percentage = percentageState.toDoubleOrNull() ?: 0.0

        val calculatedFall = if (fall != 0.0) (length / gradient).toString() else ""
        val calculatedGradient = if (gradient != 0.0) (length / fall).toString() else ""
        val calculatedLength = if (length != 0.0) (gradient * fall).toString() else ""
        val calculatedPercentage = if (percentage != 0.0) (gradient / 100).toString() else ""

        fallState = calculatedFall
        gradientState = calculatedGradient
        lengthState = calculatedLength
        percentageState = calculatedPercentage
    }


    fun clearAll() {
        fallState = ""
        gradientState = ""
        lengthState = ""
        percentageState = ""
    }

    fun updateFall(userInput: String) {
        fallState = userInput
    }

    fun updateGradient(userInput: String) {
        gradientState = userInput
    }

    fun updateLength(userInput: String) {
        lengthState = userInput
    }

    fun updatePercentage(userInput: String) {
        percentageState = userInput
    }
}