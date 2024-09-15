package com.example.trademate.ui.GradientMate.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trademate.R
import com.example.trademate.ui.GradientMate.Class.GradientViewModel

@Composable
fun HomeScreen (modifier: Modifier = Modifier) {

    val viewModel = GradientViewModel()
        Image(
            painter = painterResource(R.drawable.gradientmatetemplate__3_),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alpha = 0.9F,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = modifier
        ) {
            Banner(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 40.dp))
            Spacer(modifier = Modifier.padding(30.dp))
            UserInputRow(
                viewModel = viewModel,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            )
            Spacer(modifier = Modifier.padding(25.dp))
            ResultsRow(viewModel = viewModel)
            BannerAd(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
            )
        }
    }

@Preview
@Composable
fun PreviewHomeScreen(){
    MaterialTheme {
        HomeScreen()
    }
}
