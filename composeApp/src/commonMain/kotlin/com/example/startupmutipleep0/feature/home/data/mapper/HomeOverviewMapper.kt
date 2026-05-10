package com.example.startupmutipleep0.feature.home.data.mapper

import com.example.startupmutipleep0.feature.home.data.remote.dto.HomeOverviewDto
import com.example.startupmutipleep0.feature.home.domain.model.HomeOverview

fun HomeOverviewDto.toDomain(): HomeOverview =
    HomeOverview(
        title = title.replaceFirstChar { it.uppercase() },
        description = body,
    )
