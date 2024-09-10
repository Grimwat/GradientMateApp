package com.example.trademate.ui.GradientMate.Class

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GradientViewModel : ViewModel() {
    var lenghtResultState by mutableStateOf("")
    var gradientResultState by mutableStateOf ("")
    var fallResultstate by mutableStateOf("")
    var fallState by mutableStateOf("")
    var gradientState by mutableStateOf("")
    var lengthState by mutableStateOf("")
    var percentageState by mutableStateOf("")

    fun determineCalculation() {
        when {
            fallState.isNotEmpty() && gradientState.isNotEmpty()
                    && lengthState.isEmpty() -> calculateLength()

            gradientState.isNotEmpty() && lengthState.isNotEmpty()
                    && fallState.isEmpty() -> calculateFall()

            lengthState.isNotEmpty() && fallState.isNotEmpty()
                    && gradientState.isEmpty() -> calculateGradient()

            gradientState.isNotEmpty() && percentageState.isEmpty()
            -> calculatePercentage()
        }

    }

    private fun calculateLength() {
        val fall = fallState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatedLength = (gradient * fall).toString()
        lenghtResultState = calculatedLength
    }

    private fun calculateFall() {
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatedFall = (length / gradient).toString()
        fallResultstate = calculatedFall
    }

    private fun calculateGradient() {
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val fall = fallState.toDoubleOrNull() ?: 0.0
        val calculatedGradient = (fall / length).toString()
        gradientResultState = calculatedGradient
    }

    private fun calculatePercentage() {
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatePercentage = ((gradient / 100).toString())
        percentageState = calculatePercentage
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
}