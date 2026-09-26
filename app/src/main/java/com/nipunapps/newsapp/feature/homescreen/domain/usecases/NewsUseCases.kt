package com.nipunapps.newsapp.feature.homescreen.domain.usecases

import com.nipunapps.newsapp.feature.bookmark.domain.usecases.DeleteArticle
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.SelectArticles
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.UpsertArticle
import com.nipunapps.newsapp.feature.detail.domain.usecases.SelectArticle

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles,
    val selectArticle: SelectArticle
)
