package com.nipunapps.newsapp.core.common.mapper

import com.nipunapps.newsapp.core.common.dto.ArticleDto
import com.nipunapps.newsapp.core.common.model.Article
import com.nipunapps.newsapp.core.common.model.Source


fun ArticleDto.toDomain(): Article {
    return Article(
        author = author ?: "",
        content = content ?: "",
        description = description ?: "",
        publishedAt = publishedAt ?: "",
        source = source?.toDomain() ?: Source(
            id = "",
            name = ""
        ),
        title = title ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: ""
    )
}