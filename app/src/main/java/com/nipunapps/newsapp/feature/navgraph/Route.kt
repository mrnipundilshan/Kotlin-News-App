package com.nipunapps.newsapp.feature.navgraph

sealed class Route(
    val  route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route("searchScreen")
    object BookMarkScreen : Route("bookMarkScreen")
    object DetailsScreen : Route("detailsScreen")
    object AppStartNavigation: Route("appStartNavigation")
    object NewsNavigation: Route("newsNavigation")
    object NewsNavigatorScreen: Route("newsNavigatorScreen")
}