package com.nipunapps.newsapp.feature.detail.domain.usecases

import com.nipunapps.newsapp.feature.detail.domain.repository.DetailsRepository
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository

class SelectArticle(
    private val detailsRepository: DetailsRepository
) {
    suspend operator fun invoke(url: String) : Article?{
        return detailsRepository.selectArticle(url)
    }
}