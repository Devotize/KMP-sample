package com.sychev.kmp_sample.android.presentation.news_screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import domain.interactors.GetNews
import org.koin.androidx.compose.get

@Composable
fun NewsScreen(
    getNews: GetNews = get()
) {

    val news = getNews.execute().collectAsState(initial = emptyList())
    news.also {
        Log.d("ActivityMain", "NewsScreen: news; ${it.value}")
    }
    Box(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "HI",
            color = Color.Black
        )
    }
}