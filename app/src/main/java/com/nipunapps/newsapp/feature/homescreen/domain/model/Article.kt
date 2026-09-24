package com.nipunapps.newsapp.feature.homescreen.domain.model

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
)