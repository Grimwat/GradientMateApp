package com.example.trademate.ui.GradientMate.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trademate.R
import com.example.trademate.ui.GradientMate.Class.GradientViewModel

@Composable
fun ResultsRow(
    viewModel: GradientViewModel,
    modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 30.dp, start = 20.dp, top = 20.dp)
        ){

            ClearButton(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp,
                        bottom = 20.dp),
                onClick = { viewModel.clearAll() },)
            Image(
                painter = painterResource(R.drawable.lgf),
                contentDescription = null,
                modifier = Modifier.padding(top = 35.dp)
            )
        }
        Results(
            viewModel = viewModel)
    }
}

@Composable
fun Results(
    viewModel: GradientViewModel,
    modifier: Modifier = Modifier,
) {


    Row(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.Start,
        ){
            Text(
                text = "Fall:",
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Gradient:",
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Length:",
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Percentage:",
                modifier = Modifier.padding(20.dp)
            )
        }
        Column {
            Text(
                text = viewModel.fallResultState,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                modifier = Modifier.padding( end = 10.dp, top = 20.dp))
            Text(
                text = viewModel.gradientResultState,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                modifier = Modifier.padding( end = 10.dp, top = 20.dp))
            Text(
                text = viewModel.lengthResultState,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                modifier = Modifier.padding( end = 10.dp, top = 20.dp))
            Text(
                text = viewModel.percentageState,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                modifier = Modifier.padding( end = 10.dp, top = 20.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewUserInputRow() {
    MaterialTheme {
        Results(
            viewModel = GradientViewModel() )
    }
}