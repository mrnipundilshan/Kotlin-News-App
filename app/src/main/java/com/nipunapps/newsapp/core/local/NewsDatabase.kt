package com.nipunapps.newsapp.core.local

import androidx.room3.ColumnTypeConverters
import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.nipunapps.newsapp.core.common.model.Article
import com.nipunapps.newsapp.feature.bookmark.data.datasource.BookmarkDao
import com.nipunapps.newsapp.feature.detail.data.datasource.DetailsDao

@Database(entities = [Article::class], version = 1)
@ColumnTypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {
    abstract val bookmarkDao : BookmarkDao
    abstract val detailsDao : DetailsDao
}
