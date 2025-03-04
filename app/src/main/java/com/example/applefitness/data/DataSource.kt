package com.example.applefitness.data

import com.example.applefitness.R

object DataSource {
    val listOfExercises = listOf(
        Exercise(
            imageId = R.drawable.kick,
            name = "KICKBOXING"

        ),
        Exercise(
            imageId = R.drawable.hit,
            name = "HIIT"

        ),
        Exercise(
            imageId = R.drawable.meditation,
            name = "MEDITATION"

        ),
        Exercise(
            imageId = R.drawable.kick,
            name = "KICKBOXING"

        ),
        Exercise(
            imageId = R.drawable.hit,
            name = "HIIT"

        ),
        Exercise(
            imageId = R.drawable.meditation,
            name = "MEDITATION"

        )
    )
    val listOfEpisode = listOf(
        Episode(
            imageId = R.drawable.wind_1,
            title = "10min-Latest Hits-Ep86"
        ),
        Episode(
            imageId = R.drawable.wind_2,
            title = "10min-Latest Hits-Ep87"
        ),
        Episode(
            imageId = R.drawable.wind_3,
            title = "10min-Latest Hits-Ep88"
        ),
        Episode(
            imageId = R.drawable.wind_4,
            title = "10min-Latest Hits-Ep89"
        )
    )

    val listOfTraining = listOf(
        Training(
            type = "Traditional Strength Training",
            hours = "00",
            minute = "20",
            seconds = "12",
            id = "0"
        ),
        Training(
            type = "Stamina Increase Training",
            hours = "01",
            minute = "20",
            seconds = "00",
            id = "1",
        ),
        Training(
            type = "Stamina Increase Training",
            hours = "01",
            minute = "02",
            seconds = "00",
            id = "2",
        ),
        Training(
            type = "Legs Day .......",
            hours = "10",
            minute = "00",
            seconds = "00",
            id = "3",
        ),
        Training(
            type = "Burn every calorie in your body",
            hours = "02",
            minute = "00",
            seconds = "00",
            id = "4",
        )
    )
}
