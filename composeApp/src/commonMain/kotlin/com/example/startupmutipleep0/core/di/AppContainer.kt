package com.example.startupmutipleep0.core.di

import com.example.startupmutipleep0.core.data.network.createHttpClient
import com.example.startupmutipleep0.feature.home.data.remote.KtorHomeRemoteDataSource
import com.example.startupmutipleep0.feature.home.data.repository.DefaultHomeRepository
import com.example.startupmutipleep0.feature.home.domain.usecase.GetHomeOverviewUseCase

class AppContainer {
    private val httpClient = createHttpClient()
    private val homeRemoteDataSource = KtorHomeRemoteDataSource(httpClient)
    private val homeRepository = DefaultHomeRepository(homeRemoteDataSource)

    val getHomeOverviewUseCase = GetHomeOverviewUseCase(homeRepository)
}
