package com.sychev.kmp_sample.backend.api.domain.api

import com.sychev.kmp_sample.backend.api.domain.models.TopHeadlinesResource
import com.sychev.kmp_sample.backend.api.domain.models.TopHeadlinesResponse
import com.sychev.kmp_sample.backend.api.domain.models.defaultTopHeadlinesResource

interface NewsApi {

    suspend fun fetchTopHeadlines(
        resource: TopHeadlinesResource = defaultTopHeadlinesResource()
    ): TopHeadlinesResponse

}