package com.nipunapps.newsapp.feature.detail.data.repository

import com.nipunapps.newsapp.feature.detail.domain.repository.DetailsRepository
import com.nipunapps.newsapp.core.common.model.Article
import com.nipunapps.newsapp.feature.detail.data.datasource.DetailsDao

class DetailsRepositoryImpl(
    private val detailsDao: DetailsDao
) : DetailsRepository {

    override suspend fun selectArticle(url: String): Article? {
        return detailsDao.getArticle(url)
    }

}