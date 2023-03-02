package com.impl.feature.backend.repository

import com.api.domain.api.NewsApi
import com.api.repository.NewsRepository
import com.sychev.kmp_sample.core.models.Article
import com.impl.feature.backend.domain.mapper.toDomain

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    override suspend fun getTopHeadlines(): List<Article> =
        newsApi.fetchTopHeadlines().articles.map { it.toDomain() }

}