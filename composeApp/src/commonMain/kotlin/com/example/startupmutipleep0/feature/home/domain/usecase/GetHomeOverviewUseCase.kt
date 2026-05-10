package com.example.startupmutipleep0.feature.home.domain.usecase

import com.example.startupmutipleep0.core.domain.AppResult
import com.example.startupmutipleep0.feature.home.domain.model.HomeOverview
import com.example.startupmutipleep0.feature.home.domain.repository.HomeRepository

class GetHomeOverviewUseCase(
    private val repository: HomeRepository,
) {
    suspend operator fun invoke(): AppResult<HomeOverview> = repository.getOverview()
}
