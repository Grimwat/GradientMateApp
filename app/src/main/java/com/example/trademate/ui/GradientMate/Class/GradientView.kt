package com.example.trademate.ui.GradientMate.Class

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GradientViewModel : ViewModel() {
    var lengthResultState by mutableStateOf("")
    var gradientResultState by mutableStateOf ("")
    var fallResultState by mutableStateOf("")
    var fallState by mutableStateOf("")
    var gradientState by mutableStateOf("")
    var lengthState by mutableStateOf("")
    var percentageState by mutableStateOf("")

    fun determineCalculation() {
        when {
            fallState.isNotEmpty() && gradientState.isNotEmpty()
                    && lengthState.isEmpty() -> {calculateLength()
            lengthResultState = "${lengthState}m"}

            gradientState.isNotEmpty() && lengthState.isNotEmpty()
                    && fallState.isEmpty() -> {calculateFall()
                fallResultState = "${fallState}m"}

            lengthState.isNotEmpty() && fallState.isNotEmpty()
                    && gradientState.isEmpty() -> {calculateGradient()
                gradientResultState = "1:${gradientState}"}

            gradientState.isNotEmpty() && percentageState.isEmpty()
            -> {calculatePercentage()
            percentageState = "${percentageState}%" }
        }

    }

    private fun calculateLength() {
        val fall = fallState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatedLength = (gradient * fall).toString()
        lengthState = calculatedLength
    }

    private fun calculateFall() {
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatedFall = (length / gradient).toString()
        fallState = calculatedFall
    }

    private fun calculateGradient() {
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val fall = fallState.toDoubleOrNull() ?: 0.0
        val calculatedGradient = (fall / length).toString()
        gradientState = calculatedGradient
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
            fallResultState = ""
            gradientResultState = ""
            lengthResultState = ""
        }

    fun updateFall(userInput: String) {
        fallState = userInput
        determineCalculation()
    }

    fun updateGradient(userInput: String) {
        gradientState = userInput
        determineCalculation()
    }

    fun updateLength(userInput: String) {
        lengthState = userInput
        determineCalculation()
    }
}