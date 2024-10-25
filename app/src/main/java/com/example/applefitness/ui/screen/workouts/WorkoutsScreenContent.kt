package com.example.applefitness.ui.screen.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.applefitness.ui.screen.workouts.components.TrainingBox2
import com.example.applefitness.ui.screen.workouts.components.WorkoutBox
import com.example.applefitness.ui.theme.AppleFitnessTheme
import com.example.applefitness.ui.theme.Green01

@Composable
fun WorkoutsScreenContent(training: Training
                          ,modifier: Modifier,
                          onClick:()->Unit){
Column(verticalArrangement = Arrangement.spacedBy(14.dp),
    modifier = modifier
        .fillMaxSize()
        .background(color = Color.Black)) {
    TrainingBox2(training)
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.workouts_details),
            fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
            fontSize = 22.sp,
            lineHeight = 26.25.sp,
            color = Color.White
        )
        Text(
            text = stringResource(R.string.show_more),
            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
            fontSize = 18.sp,
            lineHeight = 21.48.sp,
            color = Green01
        )
    }
    WorkoutBox(training = training, ooClick = {onClick()})
}
}


@Preview(showBackground = true)
@Composable
fun WorkoutPreview() {
    AppleFitnessTheme {
        WorkoutsScreenContent(DataSource.listOfTraining.first(),
            modifier = Modifier
        ) {}

    }
}