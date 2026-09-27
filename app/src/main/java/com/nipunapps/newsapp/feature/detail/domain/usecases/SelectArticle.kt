package com.nipunapps.newsapp.feature.detail.domain.usecases

import com.nipunapps.newsapp.feature.detail.domain.repository.DetailsRepository
import com.nipunapps.newsapp.core.common.model.Article

class SelectArticle(
    private val detailsRepository: DetailsRepository
) {
    suspend operator fun invoke(url: String) : Article?{
        return detailsRepository.selectArticle(url)
    }
}