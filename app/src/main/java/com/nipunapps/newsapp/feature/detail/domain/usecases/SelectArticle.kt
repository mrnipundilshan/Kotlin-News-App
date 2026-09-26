package com.nipunapps.newsapp.feature.detail.domain.usecases

import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDao
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

class SelectArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(url: String) : Article?{
        return newsDao.getArticle(url)
    }
}