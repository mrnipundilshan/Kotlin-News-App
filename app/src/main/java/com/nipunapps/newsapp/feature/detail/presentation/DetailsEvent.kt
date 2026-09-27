package com.nipunapps.newsapp.feature.detail.presentation

import com.nipunapps.newsapp.core.common.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}