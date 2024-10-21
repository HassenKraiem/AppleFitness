package com.example.applefitness.ui.screen.workouts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applefitness.R
import com.example.applefitness.data.DataSource
import com.example.applefitness.data.Training
import com.example.applefitness.ui.theme.AppleFitnessTheme
import com.example.applefitness.ui.theme.Gris06

@Composable
fun TrainingBox2(
    training: Training
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(9.dp),
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .padding(vertical = 25.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.training_icon),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Column(
            verticalArrangement = Arrangement
                .spacedBy(14.dp)
        ) {
            Text(
                text = training.type,
                fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                fontSize = 18.sp,
                lineHeight = 21.48.sp,
                color = Color.White
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "3:05 AM -",
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 16.sp,
                    lineHeight = 19.09.sp,
                    color = Gris06,
                )
                Text(
                    text = " 3:07 AM",
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 16.sp,
                    lineHeight = 19.09.sp,
                    color = Gris06,
                )
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun Training2Preview() {
    AppleFitnessTheme {
        TrainingBox2(DataSource.listOfTraining.first())

    }
}