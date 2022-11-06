package com.sychev.kmp_sample.android.presentation.news_screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import store.LoadNews
import store.NewsStore

@Composable
fun NewsScreen(
    store: NewsStore = get()
) {
    val state = store.state
    val articles = state.articles.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    scope.launch {
        store.send(LoadNews)
    }
    articles.also {
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