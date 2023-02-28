package com.sychev.kmp_sample.android.presentation.news_screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sychev.kmp_sample.core.models.Article
import com.sychev.kmp_sample.shared.design.Dimens
import org.koin.androidx.compose.get
import store.LoadNews
import store.NewsStore

@Composable
fun NewsScreen(
    store: NewsStore = get()
) {
    val state = store.state
    val articles = state.articles.collectAsState(initial = emptyList())
    store.send(LoadNews)
    articles.also {
        Log.d("ActivityMain", "NewsScreen: news; ${it.value}")
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(articles.value) { article ->
            ArticleWithImageCard(article = article)
        }
    }
}

@Composable
private fun ArticleWithImageCard(
    article: Article,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(Dimens.outer_12.dp)
        ) {
            Text(text = article.title)

            Spacer(modifier = Modifier.height(Dimens.outer_8.dp))
            AsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp),
                model = article.imageUrl,
                contentDescription = null,
            )
        }
    }
}
