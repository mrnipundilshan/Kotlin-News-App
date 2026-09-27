package com.nipunapps.newsapp.core.common.mapper

import com.nipunapps.newsapp.core.common.dto.SourceDto
import com.nipunapps.newsapp.core.common.model.Source

fun SourceDto.toDomain(): Source {
    return Source(
        id = id ?: "",
        name = name ?: ""
    )
}