package com.nipunapps.newsapp.feature.bookmark.domain.usecases

import com.nipunapps.newsapp.feature.bookmark.domain.repository.BookmarkRepository
import com.nipunapps.newsapp.core.common.model.Article

class UpsertArticle (
    private val bookmarkRepository: BookmarkRepository
){
    suspend operator fun invoke(article: Article){
        bookmarkRepository.upsertArticle(article = article)
    }
}