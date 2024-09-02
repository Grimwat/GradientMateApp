package com.example.trademate.ui.GradientMate.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun BannerAd (modifier: Modifier = Modifier){
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = {
        AdView(it).apply {
            setAdSize(AdSize.SMART_BANNER)
            adUnitId = "ca-app-pub-3940256099942544/9214589741"
            loadAd(AdRequest.Builder().build())
        }
    })

}


