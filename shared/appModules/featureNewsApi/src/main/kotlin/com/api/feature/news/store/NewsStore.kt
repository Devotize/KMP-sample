package com.api.feature.news.store

import com.sychev.kmp_sample.core.domain.store.effect.EffectTree
import com.sychev.kmp_sample.core.domain.store.Store
import com.sychev.kmp_sample.core.domain.store.effect.buildEffects
import com.sychev.kmp_sample.core.models.Article
import com.api.feature.news.domain.interactors.GetNews
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class NewsStore(
    private val getNews: GetNews
) : Store<NewsIntent, NewsUiState>() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())

    override val state: NewsUiState = NewsUiState(
        articles = _articles
    )

    override val effectTree: EffectTree = buildEffects {
        addEffect(LoadNews) {
            getNews.execute().also {
                storeScope.launch {
                    _articles.emit(it.first())
                }
            }
        }
    }
}