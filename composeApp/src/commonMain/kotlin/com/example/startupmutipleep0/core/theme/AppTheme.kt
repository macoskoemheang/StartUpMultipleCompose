package com.example.startupmutipleep0.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class ThemeMode {
    Light,
    Dark,
}

private val LightColors = lightColorScheme(
    primary = Color(0xFF15616D),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD7F4F2),
    onPrimaryContainer = Color(0xFF00383F),
    secondary = Color(0xFF7D4F50),
    secondaryContainer = Color(0xFFFFDAD8),
    tertiary = Color(0xFF4F6542),
    tertiaryContainer = Color(0xFFD2EABC),
    background = Color(0xFFF6F8F4),
    onBackground = Color(0xFF181C1A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF181C1A),
    surfaceVariant = Color(0xFFE0E7E2),
    onSurfaceVariant = Color(0xFF414942),
    outline = Color(0xFF737B74),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8AD3DD),
    onPrimary = Color(0xFF00363D),
    primaryContainer = Color(0xFF004F59),
    onPrimaryContainer = Color(0xFFA5EFF7),
    secondary = Color(0xFFFFB8B5),
    secondaryContainer = Color(0xFF633B3D),
    tertiary = Color(0xFFB7D79D),
    tertiaryContainer = Color(0xFF384E2D),
    background = Color(0xFF101413),
    onBackground = Color(0xFFE1E4DF),
    surface = Color(0xFF181D1B),
    onSurface = Color(0xFFE1E4DF),
    surfaceVariant = Color(0xFF404942),
    onSurfaceVariant = Color(0xFFC0C9C0),
    outline = Color(0xFF8A938A),
)

@Composable
fun StartupTheme(
    themeMode: ThemeMode,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (themeMode == ThemeMode.Dark) DarkColors else LightColors,
        content = content,
    )
}
