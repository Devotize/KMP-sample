package com.api.repository

import com.sychev.kmp_sample.core.models.Article

interface NewsRepository {

    suspend fun getTopHeadlines(): List<Article>

}