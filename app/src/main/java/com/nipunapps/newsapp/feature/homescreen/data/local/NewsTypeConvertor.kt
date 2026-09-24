package com.nipunapps.newsapp.feature.homescreen.data.local

import androidx.room3.ColumnTypeConverter
import androidx.room3.ProvidedColumnTypeConverter
import com.nipunapps.newsapp.feature.homescreen.domain.model.Source

@ProvidedColumnTypeConverter
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