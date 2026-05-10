package com.example.startupmutipleep0.feature.home.data.repository

import com.example.startupmutipleep0.core.domain.AppResult
import com.example.startupmutipleep0.feature.home.data.mapper.toDomain
import com.example.startupmutipleep0.feature.home.data.remote.HomeRemoteDataSource
import com.example.startupmutipleep0.feature.home.domain.model.HomeOverview
import com.example.startupmutipleep0.feature.home.domain.repository.HomeRepository

class DefaultHomeRepository(
    private val remoteDataSource: HomeRemoteDataSource,
) : HomeRepository {
    override suspend fun getOverview(): AppResult<HomeOverview> =
        try {
            AppResult.Success(remoteDataSource.getOverview().toDomain())
        } catch (throwable: Throwable) {
            AppResult.Error(throwable.message ?: "Unable to load overview")
        }
}
