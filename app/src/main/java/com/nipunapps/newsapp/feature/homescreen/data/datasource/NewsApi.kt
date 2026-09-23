package com.nipunapps.newsapp.feature.homescreen.data.datasource

import com.nipunapps.newsapp.core.utils.Constants
import com.nipunapps.newsapp.feature.homescreen.data.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ) : NewsResponse
}