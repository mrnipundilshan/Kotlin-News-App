package com.nipunapps.newsapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDao
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.domain.model.Source
import com.nipunapps.newsapp.feature.navgraph.NavGraph
import com.nipunapps.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var dao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            dao.upsert(Article(
                author = "",
                title = "Coin launches all-time high at 10,000 USD",
                description = "Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple ",
                content = "Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says AppleCoinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple ",
                publishedAt = "24 March 2023",
                source = Source(
                    id = "", name = ""
                ),
                url = "",
                urlToImage = ""
            ))
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }
        }


       enableEdgeToEdge()

        setContent {
            NewsAppTheme {

                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background).safeDrawingPadding() ){
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}
