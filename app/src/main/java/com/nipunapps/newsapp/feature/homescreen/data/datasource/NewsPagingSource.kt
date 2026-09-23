package com.nipunapps.newsapp.feature.homescreen.data.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import com.nipunapps.newsapp.feature.homescreen.data.mapper.toDomain
class NewsPagingSource (
    private val newsApi: NewsApi,
    private val sources: String
) : PagingSource<Int, Article>(){

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews(sources = sources, page = page)

            Log.d("NewsPagingSource", "Response: $newsResponse")

            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles
                .distinctBy { it.title }
                .map { it.toDomain() } // Remove Duplicates

            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page +1,
                prevKey = null
            )

        } catch (e: Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
      return state.anchorPosition?.let { anchorPosition ->
          val anchorPage = state.closestPageToPosition(anchorPosition)
          anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
      }
    }

}