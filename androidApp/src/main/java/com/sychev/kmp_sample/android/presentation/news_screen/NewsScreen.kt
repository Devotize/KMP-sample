package com.sychev.kmp_sample.android.presentation.news_screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sychev.kmp_sample.backend.api.repository.NewsRepositoryApi
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@Composable
fun NewsScreen(
    newsRepository: NewsRepositoryApi = get()
) {
    val scope = rememberCoroutineScope()
    Box(Modifier.fillMaxSize()) {
        scope.launch {
            val articles = newsRepository.getTopHeadlines()
            Log.d("ActivityMain", "NewsScreen: news; $articles")
        }
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "HI",
            color = Color.Black
        )
    }
}