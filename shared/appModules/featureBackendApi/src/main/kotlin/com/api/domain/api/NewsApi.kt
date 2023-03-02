package com.api.domain.api

import com.api.domain.models.TopHeadlinesResource
import com.api.domain.models.TopHeadlinesResponse
import com.api.domain.models.defaultTopHeadlinesResource

interface NewsApi {

    suspend fun fetchTopHeadlines(
        resource: TopHeadlinesResource = defaultTopHeadlinesResource()
    ): TopHeadlinesResponse

}