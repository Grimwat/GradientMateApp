package com.example.trademate.ui.GradientMate.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.trademate.R

@Composable
fun Banner (modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(R.drawable.banner),
        contentDescription = null,
        modifier = modifier
    )
}
