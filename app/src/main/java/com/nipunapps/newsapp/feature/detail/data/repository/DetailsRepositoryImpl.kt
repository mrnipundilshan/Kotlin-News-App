package com.nipunapps.newsapp.feature.detail.data.repository

import com.nipunapps.newsapp.core.local.NewsDao
import com.nipunapps.newsapp.feature.detail.domain.repository.DetailsRepository
import com.nipunapps.newsapp.core.common.model.Article

class DetailsRepositoryImpl(
    private val newsDao: NewsDao
) : DetailsRepository {

    override suspend fun selectArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }

}