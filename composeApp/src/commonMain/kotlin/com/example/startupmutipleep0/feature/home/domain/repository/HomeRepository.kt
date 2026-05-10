package com.example.startupmutipleep0.feature.home.domain.repository

import com.example.startupmutipleep0.core.domain.AppResult
import com.example.startupmutipleep0.feature.home.domain.model.HomeOverview

interface HomeRepository {
    suspend fun getOverview(): AppResult<HomeOverview>
}
