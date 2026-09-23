package com.nipunapps.newsapp.feature.homescreen.data.mapper

import com.nipunapps.newsapp.feature.homescreen.data.dto.SourceDto
import com.nipunapps.newsapp.feature.homescreen.domain.model.Source

fun SourceDto.toDomain(): Source {
    return Source(
        id = id ?: "",
        name = name ?: ""
    )
}