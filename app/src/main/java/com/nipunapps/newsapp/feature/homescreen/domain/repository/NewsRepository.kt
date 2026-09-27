package com.nipunapps.newsapp.feature.homescreen.domain.repository

import androidx.paging.PagingData
import com.nipunapps.newsapp.core.common.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

}