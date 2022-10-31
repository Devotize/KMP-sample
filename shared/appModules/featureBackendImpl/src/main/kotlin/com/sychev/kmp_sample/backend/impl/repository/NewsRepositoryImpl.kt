package com.sychev.kmp_sample.backend.impl.repository

import com.sychev.kmp_sample.backend.api.domain.api.NewsApi
import com.sychev.kmp_sample.backend.api.repository.NewsRepositoryApi
import com.sychev.kmp_sample.core.models.Article
import com.sychev.kmp_sample.backend.impl.domain.mapper.toDomain

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepositoryApi {

    override suspend fun getTopHeadlines(): List<Article> =
        newsApi.fetchTopHeadlines().articles.map { it.toDomain() }

}