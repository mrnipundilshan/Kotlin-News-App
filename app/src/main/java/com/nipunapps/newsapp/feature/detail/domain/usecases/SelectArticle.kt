package com.nipunapps.newsapp.feature.detail.domain.usecases

import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDao
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String) : Article?{
        return newsRepository.selectArticle(url)
    }
}