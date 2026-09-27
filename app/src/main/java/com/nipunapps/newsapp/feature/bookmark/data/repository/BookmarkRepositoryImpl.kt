package com.nipunapps.newsapp.feature.bookmark.data.repository

import com.nipunapps.newsapp.feature.bookmark.domain.repository.BookmarkRepository
import com.nipunapps.newsapp.core.common.model.Article
import com.nipunapps.newsapp.feature.bookmark.data.datasource.BookmarkDao
import kotlinx.coroutines.flow.Flow

class BookmarkRepositoryImpl(
    private val bookmarkDao: BookmarkDao
) : BookmarkRepository {

    override suspend fun upsertArticle(article: Article) {
        bookmarkDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        bookmarkDao.delete(article)
    }

    override fun selectArticles(): Flow<List<Article>> {
        return bookmarkDao.getArticles()
    }

}