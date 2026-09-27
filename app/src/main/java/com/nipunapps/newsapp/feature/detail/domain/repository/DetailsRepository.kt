package com.nipunapps.newsapp.feature.detail.domain.repository

import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

interface DetailsRepository {

    suspend fun selectArticle(url: String): Article?
}