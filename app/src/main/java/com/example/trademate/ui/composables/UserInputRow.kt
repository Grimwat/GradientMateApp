package com.example.trademate.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trademate.R

@Composable
fun UserInputRow(
    clear: () -> Unit,
    modifier: Modifier = Modifier
) {
        var fallState by remember { mutableStateOf("") }
        var gradientState by remember { mutableStateOf("") }
        var lengthState by remember { mutableStateOf("") }
        var percentageState by remember { mutableStateOf("")}
    fun calculate() {
        val fall = fallState.toDoubleOrNull() ?: return
        val gradient = gradientState.toDoubleOrNull() ?: return
        val length = lengthState.toDoubleOrNull() ?: return
        val percentage = percentageState.toDoubleOrNull() ?: return

        val calculatedFall = if (gradient != 0.0) (length / gradient).toString() else ""
        val calculatedGradient = if (fall != 0.0) (length / fall).toString() else ""
        val calculatedLength = (gradient * fall).toString()
        val calculatedPercentage = (percentage * 100).toString()

        fallState = calculatedFall
        gradientState = calculatedGradient
        lengthState = calculatedLength
        percentageState = calculatedPercentage
    }
    Column(modifier = Modifier.background(Color.Blue)) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 6.dp)
        )
        {
            Text(
                text = "Fall:",
                modifier = Modifier
                    .weight(0.5F)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.labelLarge
            )
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = fallState,
                maxLines = 1,
                onValueChange = {
                    fallState = it
                    calculate()
                },
                placeholder = { Text(stringResource(R.string.fall_mm)) },
                modifier = Modifier.weight(1.2F)
            )
            Button(
                onClick = {
                    fallState = ""
                    clear()
                },
                modifier = Modifier
                    .weight(0.6F)
                    .padding(start = 6.dp)
            )
            {
                Text(
                    text = "Clear",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 6.dp)
        )
        {
            Text(
                text = "Gradient",
                modifier = Modifier
                    .weight(0.5F)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.labelLarge
            )
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = gradientState,
                maxLines = 1,
                onValueChange = {
                    gradientState = it
                    calculate()
                },
                placeholder = { Text(stringResource(R.string.gradient_1_xx)) },
                modifier = Modifier.weight(1.2F)
            )
            Button(
                onClick = {
                    gradientState = ""
                    clear()
                },
                modifier = Modifier
                    .weight(0.6F)
                    .padding(start = 6.dp)
            )
            {
                Text(
                    text = "Clear",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 6.dp)
        )
        {
            Text(
                text = "Length:",
                modifier = Modifier
                    .weight(0.5F)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.labelLarge
            )
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = lengthState,
                maxLines = 1,
                onValueChange = {
                    lengthState = it
                    calculate()
                },
                placeholder = { Text(stringResource(R.string.length_mm)) },
                modifier = Modifier.weight(1.2F)
            )
            Button(
                onClick = {
                    lengthState = ""
                    clear()
                },
                modifier = Modifier
                    .weight(0.6F)
                    .padding(start = 6.dp)
            )
            {
                Text(
                    text = "Clear",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 6.dp)
        )
        {
            Text(
                text = "Percentage:",
                modifier = Modifier
                    .weight(0.5F)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.labelLarge
            )
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = percentageState,
                maxLines = 1,
                onValueChange = {
                    percentageState = it
                    calculate()
                },
                placeholder = { Text(stringResource(R.string.percentage)) },
                modifier = Modifier.weight(1.2F)
            )
            Button(
                onClick = {
                    percentageState = ""
                    clear()
                },
                modifier = Modifier
                    .weight(0.6F)
                    .padding(start = 6.dp)
            )
            {
                Text(
                    text = "Clear",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserInputRow() {
    MaterialTheme {
        UserInputRow(
            clear = { /*TODO*/ },
            )
    }
}