package hanz.coding.composepaging3caching.data.mappers

import hanz.coding.composepaging3caching.data.local.NewsEntity
import hanz.coding.composepaging3caching.data.remote.NewsDto
import hanz.coding.composepaging3caching.domain.News

fun NewsDto.toEntity(): NewsEntity {
    return NewsEntity(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}

fun NewsEntity.toDomain(): News {
    return News(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}