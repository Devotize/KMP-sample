package api

import domain.TopHeadlinesResource
import domain.TopHeadlinesResponse
import domain.defaultTopHeadlinesResource

interface NewsApi {

    suspend fun fetchTopHeadlines(
        resource: TopHeadlinesResource = defaultTopHeadlinesResource()
    ): TopHeadlinesResponse

}