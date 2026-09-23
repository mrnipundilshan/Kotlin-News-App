package com.nipunapps.newsapp.feature.homescreen.data.dto

import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)