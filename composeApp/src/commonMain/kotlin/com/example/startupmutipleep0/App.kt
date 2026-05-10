package com.example.startupmutipleep0

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.startupmutipleep0.core.di.AppContainer
import com.example.startupmutipleep0.core.localization.AppLanguage
import com.example.startupmutipleep0.core.navigation.AppNavigator
import com.example.startupmutipleep0.core.navigation.AppRoute
import com.example.startupmutipleep0.core.theme.StartupTheme
import com.example.startupmutipleep0.core.theme.ThemeMode
import com.example.startupmutipleep0.feature.auth.presentation.LoginScreen
import com.example.startupmutipleep0.feature.dashboard.presentation.DashboardScreen
import com.example.startupmutipleep0.feature.home.presentation.HomeViewModel
import com.example.startupmutipleep0.feature.intro.presentation.IntroScreen

@Composable
@Preview
fun App() {
    val appContainer = remember { AppContainer() }
    val homeViewModel = remember { HomeViewModel(appContainer.getHomeOverviewUseCase) }
    val navigator = remember { AppNavigator() }
    var language by remember { mutableStateOf(AppLanguage.EN) }
    var themeMode by remember { mutableStateOf(ThemeMode.Light) }

    StartupTheme(themeMode = themeMode) {
        when (navigator.route) {
            AppRoute.Intro -> IntroScreen(
                currentPage = navigator.introPage,
                onNext = { totalPages -> navigator.nextIntroPage(totalPages) },
                onBack = navigator::previousIntroPage,
                onPageChanged = { page, totalPages -> navigator.setIntroPage(page, totalPages) },
                onFinish = navigator::finishIntro,
            )
            AppRoute.Login -> LoginScreen(
                onLogin = navigator::openDashboardFromLogin,
                onForgotPassword = {},
                onSignUp = {},
            )
            AppRoute.Dashboard -> DashboardScreen(
                platformName = getPlatform().name,
                viewModel = homeViewModel,
                language = language,
                themeMode = themeMode,
                onLanguageChange = { language = it },
                onThemeModeChange = { themeMode = it },
                onLogout = navigator::logout,
            )
        }
    }
}
