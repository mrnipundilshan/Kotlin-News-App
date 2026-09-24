package com.nipunapps.newsapp.feature.homescreen.data.local

import androidx.room3.ColumnTypeConverter
import com.nipunapps.newsapp.feature.homescreen.domain.model.Source


class NewsTypeConverter {

   @ColumnTypeConverter
   fun sourceToString(source: Source): String {
       return "${source.id},${source.name}"
   }

    @ColumnTypeConverter
    fun stringToSource(source: String) : Source{
        return source.split(",").let { sourceArray ->
            Source(sourceArray[0], sourceArray[1])
        }
    }
}