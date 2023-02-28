package com.sychev.kmp_sample.backend.impl.repository

import com.sychev.kmp_sample.backend.api.domain.api.NewsApi
import com.sychev.kmp_sample.backend.api.repository.NewsRepository
import com.sychev.kmp_sample.core.models.Article
import com.sychev.kmp_sample.backend.impl.domain.mapper.toDomain

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    override suspend fun getTopHeadlines(): List<Article> =
        newsApi.fetchTopHeadlines().articles.map { it.toDomain() }

}