package com.nipunapps.newsapp.feature.detail.domain.repository

import com.nipunapps.newsapp.core.common.model.Article

interface DetailsRepository {

    suspend fun selectArticle(url: String): Article?
}