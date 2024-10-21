package com.example.applefitness.data

import com.example.applefitness.R

sealed class Screen(
    open val route: String
) {
    sealed class BottomBarScreen(
        override val route: String,
        val title: String,
        val imageId: Int):Screen(route=route) {
        data object Summary : BottomBarScreen(
            route = "summary",
            title = "Summary",
            imageId = R.drawable.summary_2
        )

        data object Fitness : BottomBarScreen(
            route = "fitness",
            title = "Fitness+",
            imageId = R.drawable.fitness_2
        )

        data object Sharing : BottomBarScreen(
            route = "sharing",
            title = "Sharing",
            imageId = R.drawable.share_2
        )
    }
    sealed class NonBottomBarScreen(
        override val route: String
    ):Screen(route=route) {
        data object WorkoutScreen : NonBottomBarScreen(
            route = "workout/{id}"
        )
        data object TimeRunningScreen:NonBottomBarScreen(
            route = "time"
        )
    }
}