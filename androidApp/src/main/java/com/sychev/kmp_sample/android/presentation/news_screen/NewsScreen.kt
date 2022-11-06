package com.sychev.kmp_sample.android.presentation.news_screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sychev.kmp_sample.core.models.Article
import com.sychev.kmp_sample.shared.design.Dimens
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import store.LoadNews
import store.NewsStore

@Preview
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
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(articles.value) { article ->
            ArticleCard(article = article)
        }
    }
}


@Composable
private fun ArticleCard(
    article: Article,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(Dimens.outer_16.dp)
                .fillMaxWidth()
                .height(160.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp),
                model = article.imageUrl,
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .padding(start = Dimens.outer_8.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Text(text = article.title)
            }
        }

    }
}
