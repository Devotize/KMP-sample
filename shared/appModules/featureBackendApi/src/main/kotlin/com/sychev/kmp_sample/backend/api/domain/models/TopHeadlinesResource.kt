package com.sychev.kmp_sample.backend.api.domain.models

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("/top-headlines")
data class TopHeadlinesResource(
    val country: String = "us"
)

fun defaultTopHeadlinesResource() = TopHeadlinesResource()