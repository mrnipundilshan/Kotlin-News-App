package com.nipunapps.newsapp.feature.homescreen.domain.usecases

import androidx.paging.PagingData
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews (
    private val newsRepository: NewsRepository
){
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}