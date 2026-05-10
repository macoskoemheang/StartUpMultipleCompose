package com.example.startupmutipleep0.feature.home.presentation

import com.example.startupmutipleep0.feature.home.domain.model.HomeOverview

data class HomeUiState(
    val isLoading: Boolean = false,
    val overview: HomeOverview? = null,
    val errorMessage: String? = null,
)
