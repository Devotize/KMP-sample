package com.sychev.kmp_sample.backend.api.repository

import com.sychev.kmp_sample.core.models.Article

interface NewsRepositoryApi {

    suspend fun getTopHeadlines(): List<Article>

}