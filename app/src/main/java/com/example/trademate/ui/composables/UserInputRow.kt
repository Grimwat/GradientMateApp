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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserInputRow(
    clear: () -> Unit,
    calculate: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    var text by remember {
        mutableStateOf("")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 6.dp)
    )
    {
        Text(
            text = "$label:",
            modifier = Modifier
                .weight(0.5F)
                .padding(end = 6.dp),
            style = MaterialTheme.typography.labelLarge
        )
        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = text,
            maxLines = 1,
            onValueChange = { newText ->
                text = newText
                calculate(newText)
            },
            placeholder = { Text("Input $label") },
            modifier = Modifier.weight(1.2F)
        )
        Button(
            onClick = {
                text = ""
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

@Preview
@Composable
fun PreviewUserInputRow() {
    MaterialTheme {
        Column(
            modifier = Modifier.background(Color.Red)
        ) {
            UserInputRow(
                label = "Fall",
                clear = {},
                calculate = {}
            )
            UserInputRow(
                label = "Gradient",
                clear = {},
                calculate = {}
            )
            UserInputRow(
                label = "Length",
                clear = {},
                calculate = {}
            )
            UserInputRow(
                label = "Percentage",
                clear = {},
                calculate = {}
            )
        }
    }
}