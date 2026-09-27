package com.nipunapps.newsapp.feature.search.presentation.viewmodels

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    object SearchNews : SearchEvent()
}