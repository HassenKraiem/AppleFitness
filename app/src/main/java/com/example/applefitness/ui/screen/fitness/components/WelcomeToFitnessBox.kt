package com.example.applefitness.ui.screen.fitness.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applefitness.R
import com.example.applefitness.ui.theme.AppleFitnessTheme
import com.example.applefitness.ui.theme.Black01
import com.example.applefitness.ui.theme.Green01
import com.example.applefitness.ui.theme.Gris03

@Composable
fun WelcomeToFitnessBox(){
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
        .aspectRatio(347/138f)
        .padding(vertical = 11.dp)
        .background(color = Black01)
        .padding(10.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth(0.5f),
            verticalArrangement = Arrangement.spacedBy(7.dp)) {
            Text(
                text = stringResource(R.string.welcome),
                color = Green01,
                fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
                fontSize = 16.sp,
                lineHeight = 19.09.sp,
                modifier = Modifier

            )
            Text(
                text = stringResource(R.string.everything_you_need_to_know),
                maxLines = 2,
                fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
                fontSize = 16.sp,
                lineHeight = 19.09.sp,
                color = Color.White
            )
        }
        Image(
            painter = painterResource(R.drawable.polygon_4),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier
                .align(alignment =Alignment.Bottom)
                .background(color = Gris03, shape = RoundedCornerShape(100))
                .padding(5.dp)

        )
    }

}
@Preview(showBackground = true)
@Composable
fun FitnessPreview() {
    AppleFitnessTheme {
        WelcomeToFitnessBox()


    }
}