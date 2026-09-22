package com.nipunapps.newsapp.feature.onboarding.presentation

import androidx.annotation.DrawableRes
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.nipunapps.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = LoremIpsum(words = 4).values.first(),
        description = LoremIpsum(words = 12).values.first(),
        image = R.drawable.onboarding1
    ),
    Page(
        title = LoremIpsum(words = 4).values.first(),
        description = LoremIpsum(words = 12).values.first(),
        image = R.drawable.onboarding2
    ),
    Page(
        title = LoremIpsum(words = 4).values.first(),
        description = LoremIpsum(words = 12).values.first(),
        image = R.drawable.onboarding3
)
)
