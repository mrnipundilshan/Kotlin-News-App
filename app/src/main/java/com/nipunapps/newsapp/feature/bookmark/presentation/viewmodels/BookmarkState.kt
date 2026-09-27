package com.nipunapps.newsapp.feature.bookmark.presentation.viewmodels

import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

data class BookmarkState(
    val articles : List<Article> = emptyList()
)