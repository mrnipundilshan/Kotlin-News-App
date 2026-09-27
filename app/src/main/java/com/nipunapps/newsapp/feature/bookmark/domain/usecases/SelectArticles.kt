package com.nipunapps.newsapp.feature.bookmark.domain.usecases

import com.nipunapps.newsapp.feature.bookmark.domain.repository.BookmarkRepository
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val bookmarkRepository: BookmarkRepository
) {
     operator fun invoke(): Flow<List<Article>> {
       return bookmarkRepository.selectArticles()
    }
}