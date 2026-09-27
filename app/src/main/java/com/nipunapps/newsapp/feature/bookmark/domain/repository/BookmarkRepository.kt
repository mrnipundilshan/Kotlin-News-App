package com.nipunapps.newsapp.feature.bookmark.domain.repository

import com.nipunapps.newsapp.core.common.model.Article
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    suspend fun upsertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun selectArticles(): Flow<List<Article>>

}