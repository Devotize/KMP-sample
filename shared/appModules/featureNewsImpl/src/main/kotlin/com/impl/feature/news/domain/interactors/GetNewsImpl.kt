package com.impl.feature.news.domain.interactors

import com.api.feature.news.domain.interactors.GetNews
import com.api.repository.NewsRepository
import com.sychev.kmp_sample.core.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsImpl(
    private val newsRepository: NewsRepository
) : GetNews {

    override fun execute(): Flow<List<Article>> = flow {
        emit(newsRepository.getTopHeadlines())
    }
}

