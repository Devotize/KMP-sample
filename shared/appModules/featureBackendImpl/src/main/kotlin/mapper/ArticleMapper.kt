package mapper

import domain.models.Article
import domain.models.Source
import domain.ArticleDto
import domain.SourceDto

fun ArticleDto.toDomain() = Article(
    source = source.toDomain(),
    author = author,
    title = title,
    description = description,
    url = url,
    imageUrl = imageUrl,
    publishedAt = publishedAt,
    content = content,
)

fun SourceDto.toDomain() = Source(
    id = id,
    name = name,
)