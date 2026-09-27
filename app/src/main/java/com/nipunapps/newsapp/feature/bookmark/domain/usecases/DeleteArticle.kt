package com.nipunapps.newsapp.feature.bookmark.domain.usecases

import com.nipunapps.newsapp.feature.bookmark.domain.repository.BookmarkRepository
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository

class DeleteArticle(
    private val bookmarkRepository: BookmarkRepository
) {
    suspend operator fun invoke(article: Article) {
        bookmarkRepository.deleteArticle(article)
    }
}