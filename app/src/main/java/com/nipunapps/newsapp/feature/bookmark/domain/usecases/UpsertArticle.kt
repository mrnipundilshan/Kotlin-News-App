package com.nipunapps.newsapp.feature.bookmark.domain.usecases

import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDao
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

class UpsertArticle (
    private val newsDao: NewsDao
){
    operator fun invoke(article: Article){

    }
}