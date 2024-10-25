package com.example.applefitness.ui.screen.workouts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.applefitness.data.Training
import com.example.applefitness.ui.screen.summary.SummaryScreenContent
import com.example.applefitness.ui.theme.AppleFitnessTheme
import com.example.applefitness.ui.theme.Black01
import com.example.applefitness.ui.theme.Black02
import com.example.applefitness.ui.theme.Green01
import com.example.applefitness.ui.theme.Red01

@Composable
fun WorkoutBox(training: Training,
               ooClick:()->Unit) {
    Column(
        modifier = Modifier
            .background(color = Black01)
            .padding(horizontal = 14.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)

        ) {
            Column {
                Text(
                    text = stringResource(R.string.workout_time),
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 18.sp,
                    lineHeight = 21.48.sp,
                    color = Color.White
                )
                Text(
                    text = "${training.hours}:${training.minute}:${training.seconds}",
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 30.sp,
                    lineHeight = 35.8.sp,
                    color = Green01
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.active_calories),
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 18.sp,
                    lineHeight = 21.48.sp,
                    color = Color.White
                )
                Text(
                    text = "${training.cal.toString()}CAL",
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 30.sp,
                    lineHeight = 35.8.sp,
                    color = Red01
                )
            }
        }
        Divider(color = Black02)
        Button(onClick = {ooClick()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Green01,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .padding(vertical = 12.dp)
                .aspectRatio(336 / 53f)

        ) {
            Text(
                text = stringResource(R.string.start_workout),
                fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
                fontSize = 18.sp,
                lineHeight = 21.48.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WorkoutPreview() {
    AppleFitnessTheme {
        WorkoutBox(training = DataSource.listOfTraining.first(),{})

    }
}