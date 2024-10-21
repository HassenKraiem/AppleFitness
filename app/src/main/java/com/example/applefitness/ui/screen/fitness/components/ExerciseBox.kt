package com.example.applefitness.ui.screen.fitness.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applefitness.R
import com.example.applefitness.data.Exercise
import com.example.applefitness.ui.theme.Gris02

@Composable
fun ExerciseBox(
    exercise: Exercise
){
    Row(horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .fillMaxWidth()
            .background(Gris02)
            .padding(11.dp)) {
        Image(
            painter = painterResource(exercise.imageId),
            contentDescription = exercise.name,
            contentScale = ContentScale.Fit
        )
        Text(
            text = exercise.name,
            fontSize = 12.sp,
            lineHeight = 14.32.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
            color = Color.White,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}