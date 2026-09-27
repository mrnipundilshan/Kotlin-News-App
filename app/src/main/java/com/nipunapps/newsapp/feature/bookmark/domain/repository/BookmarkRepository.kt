package com.nipunapps.newsapp.feature.bookmark.domain.repository

import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    suspend fun upsertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun selectArticles(): Flow<List<Article>>

}