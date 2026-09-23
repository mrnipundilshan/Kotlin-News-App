package com.nipunapps.newsapp.feature.homescreen.domain.repository

import androidx.paging.PagingData
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}