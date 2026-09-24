package com.nipunapps.newsapp.feature.homescreen.search

import androidx.paging.PagingData
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}