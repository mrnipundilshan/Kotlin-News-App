package com.nipunapps.newsapp.feature.homescreen.data.local

import androidx.room3.ColumnTypeConverters
import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article

@Database(entities = [Article::class], version = 1)
@ColumnTypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao : NewsDao

}