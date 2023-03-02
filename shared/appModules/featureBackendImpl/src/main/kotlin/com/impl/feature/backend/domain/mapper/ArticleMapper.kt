package com.impl.feature.backend.domain.mapper

import com.sychev.kmp_sample.core.models.Article
import com.sychev.kmp_sample.core.models.Source
import com.api.domain.models.ArticleDto
import com.api.domain.models.SourceDto

fun ArticleDto.toDomain() = Article(
    source = source.toDomain(),
    author = author,
    title = title,
    description = description ?: "",
    url = url,
    imageUrl = imageUrl ?: "",
    publishedAt = publishedAt ?: "",
    content = content ?: "",
)

fun SourceDto.toDomain() = Source(
    id = id,
    name = name,
)