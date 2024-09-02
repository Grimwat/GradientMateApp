package com.example.trademate.ui.GradientMate.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trademate.R
import com.example.trademate.ui.GradientMate.Class.GradientViewModel

@Composable
fun ResultsRow(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.lgf),
            contentDescription = null,
            modifier = Modifier.padding(start = 20.dp, end = 25.dp, top = 80.dp)
        )
        Results(
            viewModel = GradientViewModel())
    }
}

@Composable
fun Results(
    modifier: Modifier = Modifier,
    viewModel: GradientViewModel
) {
    Row (modifier = modifier) {
        Column {
            Text(text = "Fall:",
                modifier = Modifier.padding(20.dp)
            )
            Text(text = "Gradient:",
                modifier = Modifier.padding(20.dp)
            )
            Text(text = "Length:",
                modifier = Modifier.padding(20.dp)
            )
            Text(text = "Percentage:",
                modifier = Modifier.padding(20.dp)
            )
        }
        Column {
            Text(text = viewModel.resultstate)
            Text(text = viewModel.resultstate)
            Text(text = viewModel.resultstate)
            Text(text = viewModel.resultstate)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewUserInputRow() {
    MaterialTheme {
        Results(viewModel = GradientViewModel())
    }
}