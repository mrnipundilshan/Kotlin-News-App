package com.nipunapps.newsapp.feature.search.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nipunapps.newsapp.core.network.NewsApi
import com.nipunapps.newsapp.feature.search.data.datasource.SearchNewsPagingSource
import com.nipunapps.newsapp.core.common.model.Article
import com.nipunapps.newsapp.feature.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl (
    private val newsApi: NewsApi,

    ) : SearchRepository{

    override fun searchNews(
        searchQuery: String,
        sources: List<String>
    ): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}