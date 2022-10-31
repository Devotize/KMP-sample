package com.sychev.kmp_sample.backend.impl.domain.mapper

import com.sychev.kmp_sample.core.models.Article
import com.sychev.kmp_sample.core.models.Source
import com.sychev.kmp_sample.backend.api.domain.models.ArticleDto
import com.sychev.kmp_sample.backend.api.domain.models.SourceDto

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