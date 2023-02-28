package com.sychev.kmp_sample.backend.impl.domain.api

import com.sychev.kmp_sample.backend.impl.di.QualifierNames
import com.sychev.kmp_sample.backend.api.domain.api.NewsApi
import com.sychev.kmp_sample.backend.api.domain.models.TopHeadlinesResource
import com.sychev.kmp_sample.backend.api.domain.models.TopHeadlinesResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named


class NewsImpl() : NewsApi, KoinComponent {

    private val client: HttpClient by inject(qualifier = named(QualifierNames.news_api_client))

    override suspend fun fetchTopHeadlines(resource: TopHeadlinesResource): TopHeadlinesResponse =
        client.get(resource).body()
}