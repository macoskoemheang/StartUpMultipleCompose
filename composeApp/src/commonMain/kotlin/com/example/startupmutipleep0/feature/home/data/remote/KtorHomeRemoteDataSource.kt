package com.example.startupmutipleep0.feature.home.data.remote

import com.example.startupmutipleep0.feature.home.data.remote.dto.HomeOverviewDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorHomeRemoteDataSource(
    private val httpClient: HttpClient,
) : HomeRemoteDataSource {
    override suspend fun getOverview(): HomeOverviewDto =
        httpClient.get("https://jsonplaceholder.typicode.com/posts/1").body()
}
