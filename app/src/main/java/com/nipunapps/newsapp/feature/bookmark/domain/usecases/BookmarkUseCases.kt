package com.nipunapps.newsapp.feature.bookmark.domain.usecases

data class BookmarkUseCases(
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles,
    val upsertArticle: UpsertArticle
)
