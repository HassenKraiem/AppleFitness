package com.example.applefitness.ui.screen.summary.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
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
import com.example.applefitness.ui.theme.Black01
import com.example.applefitness.ui.theme.Green01
import com.example.applefitness.ui.theme.Gris06

@Composable
fun TrainingBox(
    training: Training,
    onClick:()->Unit
){
    Row(horizontalArrangement = Arrangement.spacedBy(9.dp),
        modifier = Modifier
        .background(color = Black01,
            shape = RoundedCornerShape(10.dp))
        .padding(horizontal = 14.dp)
        .padding(vertical = 12.dp)
        .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.training_icon),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Column {

                Text(
                    text = training.type,
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 18.sp,
                    lineHeight = 21.48.sp,
                    color = Color.White
                )
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()) {
                        Text(
                            text = "${training.hours}:${training.minute}:${training.seconds}",
                            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                            fontSize = 30.sp,
                            lineHeight = 35.8.sp,
                            color = Green01
                        )
                    Row(verticalAlignment = Alignment.CenterVertically,
                            ) {
                        Text(
                            text = "8/9/22",
                            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                            fontSize = 16.sp,
                            lineHeight = 19.09.sp,
                            color = Gris06,
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Gris06,
                            modifier = Modifier
                                .clickable {onClick()  }
                        )
                    }
                }
            }
        }


}

@Preview(showBackground = true)
@Composable
fun TrainingPreview() {
    AppleFitnessTheme {
        TrainingBox(DataSource.listOfTraining.first(),
            onClick = {})

    }
}