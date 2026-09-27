package com.nipunapps.newsapp.feature.bookmark.domain.usecases

import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDao
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}