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

    fun determineCalculation(){
        when {
            fallState.isNotEmpty() && gradientState.isNotEmpty()
                    && lengthState.isEmpty() -> calculateLength()}
        when {
            gradientState.isNotEmpty() && lengthState.isNotEmpty()
                && fallState.isEmpty() -> calculateFall()
        }
        when {
            lengthState.isNotEmpty() && fallState.isNotEmpty()
                    &&gradientState.isEmpty() -> calculateGradient()
        }
        when {gradientState.isNotEmpty() && percentageState.isEmpty()
        -> calculatePercentage()

        }

    }
    private fun calculateLength(){
        val fall = fallState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatedLength = (gradient * fall).toString()
        lengthState = calculatedLength
    }
    private fun calculateFall(){
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatedFall =  (length / gradient).toString()
        lengthState = calculatedFall
    }
    private fun calculateGradient(){
        val length = lengthState.toDoubleOrNull() ?: 0.0
        val fall = fallState.toDoubleOrNull() ?: 0.0
        val calculatedGradient = (length / fall).toString()
        gradientState = calculatedGradient
    }
    private fun calculatePercentage (){
        val gradient = gradientState.toDoubleOrNull() ?: 0.0
        val calculatePercentage = ((gradient / 100).toString())
        gradientState = calculatePercentage
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