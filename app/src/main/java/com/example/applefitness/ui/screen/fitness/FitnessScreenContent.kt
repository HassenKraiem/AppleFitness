package com.example.applefitness.ui.screen.fitness

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applefitness.R
import com.example.applefitness.data.DataSource
import com.example.applefitness.ui.screen.fitness.components.CyclingEp
import com.example.applefitness.ui.screen.fitness.components.ExerciseBox
import com.example.applefitness.ui.screen.fitness.components.WelcomeToFitnessBox
import com.example.applefitness.ui.theme.AppleFitnessTheme
import com.example.applefitness.ui.theme.Gris04

@Composable
fun FitnessScreenContent(modifier: Modifier=Modifier) {
    val exercises= DataSource.listOfExercises
    val episodes =DataSource.listOfEpisode
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(horizontal = 21.dp)
            .padding(bottom = 100.dp)
            .padding(top = 44.dp)

    ) {
        Text(
            text = "Fitness+",
            fontSize = 34.sp,
            lineHeight = 40.57.sp,
            fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
            //textAlign = TextAlign.Start
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(vertical = 11.dp)) {
            items(exercises){exercise->
                ExerciseBox(exercise)

            }
        }
        WelcomeToFitnessBox()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.cycling_for_the_weekend),
            fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
            fontSize = 24.sp,
            lineHeight = 28.64.sp,
            color = Color.White
        )
        Text(
            text = stringResource(R.string.energizing_10_minute_rides),
            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
            fontSize = 16.sp,
            lineHeight = 19.09.sp,
            color = Gris04,
            modifier = Modifier
                .padding(8.dp)

        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(episodes){ episode->
                CyclingEp(episode)

            }
        }



    }
}
@Preview(showBackground = true)
@Composable
fun FitnessPreview() {
    AppleFitnessTheme {
        FitnessScreenContent(Modifier.fillMaxSize())


    }
}