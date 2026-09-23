package com.nipunapps.newsapp.feature.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.nipunapps.newsapp.feature.homescreen.presentation.HomeScreen
import com.nipunapps.newsapp.feature.homescreen.presentation.viewmodels.HomeViewModel
import com.nipunapps.newsapp.feature.onboarding.presentation.OnBoardingScreen
import com.nipunapps.newsapp.feature.onboarding.presentation.viewmodels.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )

            }
        }


        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(
                route = Route.NewsNavigatorScreen.route
            ){
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles = articles, navigate = {})
            }
        }

    }
}