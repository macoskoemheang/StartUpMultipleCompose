package com.example.startupmutipleep0.feature.intro.presentation

data class IntroPage(
    val step: String,
    val title: String,
    val description: String,
    val accent: String,
)

val introPages = listOf(
    IntroPage("01", "Welcome to Startup Multiple", "A clean Compose Multiplatform starter for Android and iOS.", "KMP"),
    IntroPage("02", "Clean Architecture", "Features are separated into presentation, domain, and data layers.", "ARC"),
    IntroPage("03", "Shared API Layer", "Ktor is ready for common API calls with platform engines behind it.", "API"),
    IntroPage("04", "Localization Ready", "Khmer, English, and Chinese language choices are built into the app.", "L10N"),
    IntroPage("05", "Theme Control", "Light and dark modes are managed globally from one place.", "UI"),
    IntroPage("06", "Dashboard First", "Bottom navigation keeps feature areas clear and easy to expand.", "NAV"),
    IntroPage("07", "Ready to Build", "Start from a complete flow: intro, login, dashboard, and settings.", "GO"),
)
