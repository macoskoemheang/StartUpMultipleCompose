package com.example.startupmutipleep0.feature.dashboard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.startupmutipleep0.core.localization.AppLanguage
import com.example.startupmutipleep0.core.theme.ThemeMode
import com.example.startupmutipleep0.feature.home.presentation.HomeScreen
import com.example.startupmutipleep0.feature.home.presentation.HomeViewModel

@Composable
fun DashboardScreen(
    platformName: String,
    viewModel: HomeViewModel,
    language: AppLanguage,
    themeMode: ThemeMode,
    onLanguageChange: (AppLanguage) -> Unit,
    onThemeModeChange: (ThemeMode) -> Unit,
    onLogout: () -> Unit,
) {
    var selectedTab by remember { mutableStateOf(DashboardTab.Home) }

    Scaffold(
        bottomBar = {
            GlobalBottomNavigation(
                selectedTab = selectedTab,
                onTabSelected = { tab ->
                    if (selectedTab != tab) {
                        selectedTab = tab
                    }
                },
            )
        },
    ) { paddingValues ->
        when (selectedTab) {
            DashboardTab.Home -> DashboardHomeScreen(
                paddingValues = paddingValues,
                onOpenSettings = { selectedTab = DashboardTab.Settings },
                onLogout = onLogout,
            )
            DashboardTab.Activity -> DashboardActivityScreen(paddingValues = paddingValues)
            DashboardTab.Settings -> Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                HomeScreen(
                    platformName = platformName,
                    viewModel = viewModel,
                    language = language,
                    themeMode = themeMode,
                    onLanguageChange = onLanguageChange,
                    onThemeModeChange = onThemeModeChange,
                )
            }
        }
    }
}

@Composable
private fun GlobalBottomNavigation(
    selectedTab: DashboardTab,
    onTabSelected: (DashboardTab) -> Unit,
) {
    Surface(
        tonalElevation = 3.dp,
        shadowElevation = 6.dp,
        color = MaterialTheme.colorScheme.surface,
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 0.dp,
        ) {
        DashboardTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                ),
                icon = {
                    Surface(
                        modifier = Modifier.size(28.dp),
                        shape = RoundedCornerShape(8.dp),
                        color = if (selectedTab == tab) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        },
                        contentColor = if (selectedTab == tab) {
                            MaterialTheme.colorScheme.onPrimary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        },
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = tab.icon,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                },
                label = { Text(tab.title) },
            )
        }
        }
    }
}

@Composable
private fun DashboardHomeScreen(
    paddingValues: PaddingValues,
    onOpenSettings: () -> Unit,
    onLogout: () -> Unit,
) {
    DashboardPage(paddingValues = paddingValues) {
        DashboardHeader(
            title = "Current Trip",
            subtitle = "Track your travel budget before small expenses become surprises.",
            trailing = {
                TextButton(onClick = onLogout) {
                    Text("Logout")
                }
            },
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            MetricCard(
                modifier = Modifier.weight(1f),
                value = "\$1,240",
                label = "Trip budget",
            )
            MetricCard(
                modifier = Modifier.weight(1f),
                value = "\$385",
                label = "Spent",
            )
        }

        TripBudgetCard()

        FeatureCard(
            title = "Smart trip categories",
            body = "Group expenses by hotel, food, transport, tickets, shopping, and emergency costs.",
        )
        FeatureCard(
            title = "Personalize your travel workspace",
            body = "Language, dark mode, platform info, and the API demo are available in Settings.",
            action = "Open settings",
            onAction = onOpenSettings,
        )
    }
}

@Composable
private fun DashboardActivityScreen(
    paddingValues: PaddingValues,
) {
    DashboardPage(paddingValues = paddingValues) {
        DashboardHeader(
            title = "Spending",
            subtitle = "Review trip expenses by category and spot budget pressure early.",
        )
        FeatureCard(
            title = "Today",
            body = "Breakfast \$12, city train \$4, museum ticket \$18, dinner deposit \$25.",
        )
        FeatureCard(
            title = "This trip",
            body = "Food is currently the highest category. Transport is still under plan.",
        )
        FeatureCard(
            title = "Navigation safety",
            body = "Intro pages are bounded, repeated tab taps are ignored, and dashboard access opens from login only.",
        )
    }
}

@Composable
private fun TripBudgetCard() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = "Cambodia Weekend",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "3 days · 2 travelers",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.78f),
                    )
                }
                Text(
                    text = "69%",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.22f),
                        shape = RoundedCornerShape(8.dp),
                    ),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.31f)
                        .height(8.dp)
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(8.dp),
                        ),
                )
            }
            Text(
                text = "\$855 remaining from the planned budget",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.84f),
            )
        }
    }
}

@Composable
private fun DashboardPage(
    paddingValues: PaddingValues,
    content: @Composable ColumnScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(paddingValues),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
                .widthIn(max = 720.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = content,
        )
    }
}

@Composable
private fun DashboardHeader(
    title: String,
    subtitle: String,
    trailing: (@Composable () -> Unit)? = null,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        trailing?.invoke()
    }
}

@Composable
private fun MetricCard(
    modifier: Modifier,
    value: String,
    label: String,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.75f),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun FeatureCard(
    title: String,
    body: String,
    action: String? = null,
    onAction: (() -> Unit)? = null,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.18f),
                shape = RoundedCornerShape(8.dp),
            ),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = body,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            if (action != null && onAction != null) {
                TextButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = onAction,
                ) {
                    Text(action)
                }
            }
        }
    }
}
