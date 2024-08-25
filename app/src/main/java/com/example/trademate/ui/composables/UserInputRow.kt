package com.example.trademate.ui.composables

import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.trademate.R
import com.example.trademate.ui.Class.GradientViewModel

@Composable
fun UserInputRow(
    viewModel: GradientViewModel,
    modifier: Modifier = Modifier
) {
    val fallState by viewModel::fallState
    val gradientState by viewModel::gradientState
    val lengthState by viewModel::lengthState
    val percentageState by viewModel::percentageState

    Column(modifier = Modifier.background(Color.Blue)) {
        UserInputField(
            label = "Fall:",
            value = fallState,
            placeholder = R.string.fall_mm,
            onValueChange = {
                viewModel.fallState = it
                viewModel.calculate()
            },
            onClear = { viewModel.clearAll() },
            modifier = modifier
        )
        UserInputField(
            label = "Gradient:",
            value = gradientState,
            placeholder = R.string.gradient_1_xx,
            onValueChange = {
                viewModel.gradientState = it
                viewModel.calculate()
            },
            onClear = { viewModel.clearAll() },
            modifier = modifier
        )
        UserInputField(
            label = "Length:",
            value = lengthState,
            placeholder = R.string.length_mm,
            onValueChange = {
                viewModel.lengthState = it
                viewModel.calculate()
            },
            onClear = { viewModel.clearAll() },
            modifier = modifier
        )
        UserInputField(
            label = "Percentage:",
            value = percentageState,
            placeholder = R.string.percentage,
            onValueChange = {
                viewModel.percentageState = it
                viewModel.calculate()
            },
            onClear = { viewModel.clearAll() },
            modifier = modifier
        )
    }
}

@Composable
fun UserInputField(
    label: String,
    value: String,
    placeholder: Int,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 6.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier
                .weight(0.5F)
                .padding(end = 6.dp),
            style = MaterialTheme.typography.labelLarge
        )
        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = value,
            maxLines = 1,
            onValueChange = onValueChange,
            placeholder = { Text(stringResource(placeholder)) },
            modifier = Modifier.weight(1.2F)
        )
        Button(
            onClick = onClear,
            modifier = Modifier
                .weight(0.6F)
                .padding(start = 6.dp)
        ) {
            Text(
                text = "Clear",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewUserInputRow() {
    MaterialTheme {
        UserInputRow(
            viewModel = GradientViewModel()
        )
    }
}