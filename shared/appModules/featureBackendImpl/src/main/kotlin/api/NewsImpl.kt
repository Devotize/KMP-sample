package api

import di.QualifierNames
import domain.TopHeadlinesResource
import domain.TopHeadlinesResponse
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