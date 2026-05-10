package com.example.startupmutipleep0.feature.home.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeOverviewDto(
    @SerialName("title")
    val title: String,
    @SerialName("body")
    val body: String,
)
