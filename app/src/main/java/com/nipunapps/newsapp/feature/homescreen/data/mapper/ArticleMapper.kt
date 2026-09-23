package com.nipunapps.newsapp.feature.homescreen.data.mapper

import com.nipunapps.newsapp.feature.homescreen.data.dto.ArticleDto
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.model.Source


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