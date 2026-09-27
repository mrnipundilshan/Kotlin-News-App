package com.nipunapps.newsapp.feature.detail.data.datasource

import androidx.room3.Query
import com.nipunapps.newsapp.core.common.model.Article

interface DetailsDao {
    @Query("SELECT * FROM Article WHERE url=:url")
    suspend fun getArticle(url: String): Article?
}