package com.example.startupmutipleep0.core.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed interface AppRoute {
    data object Intro : AppRoute
    data object Login : AppRoute
    data object Dashboard : AppRoute
}

class AppNavigator {
    var route by mutableStateOf<AppRoute>(AppRoute.Intro)
        private set

    var introPage by mutableStateOf(0)
        private set

    fun nextIntroPage(totalPages: Int) {
        if (totalPages <= 0) return
        introPage = (introPage + 1).coerceAtMost(totalPages - 1)
    }

    fun previousIntroPage() {
        introPage = (introPage - 1).coerceAtLeast(0)
    }

    fun finishIntro() {
        if (route == AppRoute.Intro) {
            route = AppRoute.Login
        }
    }

    fun openDashboardFromLogin() {
        if (route == AppRoute.Login) {
            route = AppRoute.Dashboard
        }
    }

    fun logout() {
        if (route == AppRoute.Dashboard) {
            route = AppRoute.Login
        }
    }
}
