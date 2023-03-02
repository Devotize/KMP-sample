package com.impl.feature.backend.domain.api

import com.impl.feature.backend.di.QualifierNames
import com.api.domain.api.NewsApi
import com.api.domain.models.TopHeadlinesResource
import com.api.domain.models.TopHeadlinesResponse
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