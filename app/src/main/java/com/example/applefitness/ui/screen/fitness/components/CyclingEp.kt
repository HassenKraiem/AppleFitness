package com.example.applefitness.ui.screen.fitness.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applefitness.R
import com.example.applefitness.data.Episode
import com.example.applefitness.ui.theme.Gris05

@Composable
fun CyclingEp(
    episode: Episode
){
    Column(modifier = Modifier) {
        Image(
            painter = painterResource(episode.imageId),
            contentDescription = episode.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(229.dp)
                .height(136.dp)
                .background(color = Gris05)
                .padding(10.dp)
        )
        Text(
            text = episode.chanel,
            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
            fontSize = 16.sp,
            lineHeight = 19.09.sp,
            color = Color.White
        )
        Text(
            text = episode.title,
            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
            fontSize = 14.sp,
            lineHeight = 16.71.sp,
            color = Color.White
        )
    }
}