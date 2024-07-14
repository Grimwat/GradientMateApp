package com.example.trademate.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.trademate.R

@Composable
fun HomeScreen (modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.pexels_jacp_3421636)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alpha = 0.9F
        )
    Box(
        modifier = modifier) {
        UserInputRow(
            clear = { /*TODO*/ },
            calculate = {},
            label = "",
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
