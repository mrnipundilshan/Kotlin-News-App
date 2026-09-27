package com.nipunapps.newsapp.feature.bookmark.presentation.viewmodels

import com.nipunapps.newsapp.core.common.model.Article

data class BookmarkState(
    val articles : List<Article> = emptyList()
)