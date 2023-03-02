package com.api.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    @SerialName("source")
    val source: SourceDto,
    @SerialName("author")
    val author: String? = null,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String? = null,
    @SerialName("urls")
    val url: String = "",
    @SerialName("urlToImage")
    val imageUrl: String? = null,
    @SerialName("publishedAt")
    val publishedAt: String? = null,
    @SerialName("content")
    val content: String? = null,
)

@Serializable
data class SourceDto(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String,
)

