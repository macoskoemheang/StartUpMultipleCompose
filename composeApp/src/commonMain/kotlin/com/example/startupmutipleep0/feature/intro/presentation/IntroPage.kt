package com.example.startupmutipleep0.feature.intro.presentation

data class IntroPage(
    val step: String,
    val title: String,
    val description: String,
    val accent: String,
    val detail: String,
)

val introPages = listOf(
    IntroPage("01", "Plan every trip budget", "Set a clear spending plan before the journey starts.", "\$", "Flights, hotels, food, transport, and activities stay in one simple view."),
    IntroPage("02", "Capture expenses fast", "Add costs while moving between cities, airports, and meetings.", "+", "Quick entries help you record the amount, category, date, and note before you forget."),
    IntroPage("03", "Split costs with friends", "Track who paid and see what each traveler owes.", "%", "Group trips become easier when shared expenses and personal purchases are separated."),
    IntroPage("04", "Understand your spending", "See where the trip money goes with clean category summaries.", "CH", "Daily totals and category cards make overspending easier to notice early."),
    IntroPage("05", "Works across devices", "Your trip expense flow is designed for Android and iOS.", "MP", "The shared app structure keeps the experience consistent wherever you manage the trip."),
    IntroPage("06", "Ready for any country", "Switch language and theme from the app settings.", "KH", "Khmer, English, Chinese, light mode, and dark mode are ready for your travel workflow."),
)
