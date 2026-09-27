package com.nipunapps.newsapp.core.local

import androidx.room3.ColumnTypeConverters
import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.nipunapps.newsapp.core.common.model.Article

@Database(entities = [Article::class], version = 1)
@ColumnTypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao : NewsDao

}