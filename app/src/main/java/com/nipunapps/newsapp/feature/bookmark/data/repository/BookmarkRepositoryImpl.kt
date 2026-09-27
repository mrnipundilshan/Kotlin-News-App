package com.nipunapps.newsapp.feature.bookmark.data.repository

import com.nipunapps.newsapp.feature.bookmark.domain.repository.BookmarkRepository
import com.nipunapps.newsapp.core.local.NewsDao
import com.nipunapps.newsapp.core.common.model.Article
import kotlinx.coroutines.flow.Flow

class BookmarkRepositoryImpl(
    private val newsDao: NewsDao
) : BookmarkRepository {

    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override fun selectArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}