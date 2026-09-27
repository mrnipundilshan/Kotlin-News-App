package com.nipunapps.newsapp.feature.bookmark.domain.usecases

import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDao
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

class UpsertArticle (
    private val newsDao: NewsDao
){
    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }
}