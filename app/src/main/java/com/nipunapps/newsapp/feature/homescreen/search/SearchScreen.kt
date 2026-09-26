package com.nipunapps.newsapp.feature.homescreen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.nipunapps.newsapp.core.components.ArticlesList
import com.nipunapps.newsapp.core.dimension.Dimension.MediumPadding1
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.presentation.components.SearchBar
import com.nipunapps.newsapp.feature.navgraph.Route

@Composable
fun SearchScreen (
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
){
    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ){
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {event(SearchEvent.SearchNews)}
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        state.articles?.let { it ->
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = { navigateToDetails(it)})
        }
    }
}