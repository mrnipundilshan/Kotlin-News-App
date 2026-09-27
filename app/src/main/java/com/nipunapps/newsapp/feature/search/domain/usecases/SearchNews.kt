package com.nipunapps.newsapp.feature.search.domain.usecases

import androidx.paging.PagingData
import com.nipunapps.newsapp.core.common.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}