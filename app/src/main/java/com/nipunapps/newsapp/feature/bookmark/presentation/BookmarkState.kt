package com.nipunapps.newsapp.feature.bookmark.presentation

import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

data class BookmarkState(
    val articles : List<Article> = emptyList()
)
