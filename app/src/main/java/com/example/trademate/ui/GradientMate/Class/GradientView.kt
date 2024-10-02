package com.example.trademate.ui.GradientMate.Class

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Locale

class GradientViewModel : ViewModel() {
    var lengthResultState by mutableStateOf("")
    var gradientResultState by mutableStateOf ("")
    var fallResultState by mutableStateOf("")
    var fallState by mutableStateOf("")
    var gradientState by mutableStateOf("")
    var lengthState by mutableStateOf("")
    var percentageState by mutableStateOf("")

    private fun determineCalculation() {
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

        println("Fall: $fall, Gradient: $gradient")

        if (fall == 0.0 || gradient == 0.0){
            lengthState = "undefined"
            return
        }
        val calculatedLength = String.format(Locale.getDefault(),"%.2f",gradient * fall)
        lengthState = calculatedLength
    }

    private fun calculateFall() {
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0

        println("Length: $length, Gradient: $gradient")

        if (gradient == 0.0) {
            fallState = "undefined"
            return
        }
        val calculatedFall = String.format(Locale.getDefault(),"%.2f", length / gradient)
        fallState = calculatedFall
    }

    private fun calculateGradient() {
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val fall = fallState.toDoubleOrNull() ?: 0.0

        println("Length: $length, Fall: $fall")

        if (fall == 0.0){
            gradientState = "undefined"
            return
        }
        val calculatedGradient = String.format(Locale.getDefault(),"%.2f", length / fall)
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