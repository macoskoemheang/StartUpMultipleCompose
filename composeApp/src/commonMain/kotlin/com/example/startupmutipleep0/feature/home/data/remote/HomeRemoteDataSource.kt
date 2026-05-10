package com.example.startupmutipleep0.feature.home.data.remote

import com.example.startupmutipleep0.feature.home.data.remote.dto.HomeOverviewDto

interface HomeRemoteDataSource {
    suspend fun getOverview(): HomeOverviewDto
}
