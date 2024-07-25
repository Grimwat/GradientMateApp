package com.example.trademate.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.trademate.R

@Composable
fun HomeScreen (modifier: Modifier = Modifier) {
    val pipes = painterResource(R.drawable.pexels_jacp_3421636)
        Image(
            painter = pipes,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alpha = 0.9F,
        )
    Column(
        modifier = modifier
    ) {
        Banner()

        UserInputRow(
            clear = { /*TODO*/ },
        )
    }
}
@Composable
fun Banner (modifier: Modifier = Modifier) {
val banner = painterResource(R.drawable.banner)

    Image(painter = banner,
        contentDescription = null,
        modifier = modifier
        )
}



@Preview
@Composable
fun PreviewHomeScreen(){
    MaterialTheme {
        HomeScreen()
    }
}
