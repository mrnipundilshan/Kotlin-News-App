package com.nipunapps.newsapp.feature.search.presentation.viewmodels

import androidx.paging.PagingData
import com.nipunapps.newsapp.core.common.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}