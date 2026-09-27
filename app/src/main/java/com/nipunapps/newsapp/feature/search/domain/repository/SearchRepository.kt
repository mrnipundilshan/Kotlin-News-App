package com.nipunapps.newsapp.feature.search.domain.repository

import androidx.paging.PagingData
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun searchNews(searchQuery: String, sources : List<String>): Flow<PagingData<Article>>
}