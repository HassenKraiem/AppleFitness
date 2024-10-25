package com.example.applefitness.ui.screen.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController
import com.example.applefitness.R
import com.example.applefitness.data.DataSource
import com.example.applefitness.ui.screen.summary.components.TrainingBox
import com.example.applefitness.ui.theme.AppleFitnessTheme
import com.example.applefitness.ui.theme.Green01
import com.example.applefitness.ui.theme.Gris07

@Composable
fun SummaryScreenContent(modifier: Modifier,
                         navController: NavController,
) {
    Scaffold(modifier = modifier
        .padding(top = 28.dp)
        .padding(horizontal = 18.dp)
        ,topBar = {
        Text(
            text = stringResource(R.string.sunday_apr_9),
            fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
            fontSize = 14.sp,
            lineHeight = 16.71.sp,
            color = Gris07
        )

    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .padding(innerPadding)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.summary),
                    fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
                    fontSize = 40.sp,
                    lineHeight = 47.73.sp,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(52.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Workouts",
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 22.sp,
                    lineHeight = 26.25.sp,
                    color = Color.White
                )
                Text(
                    text = "Show More",
                    fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                    fontSize = 18.sp,
                    lineHeight = 21.48.sp,
                    color = Green01
                )
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(20.dp)
            ) {
                items(DataSource.listOfTraining) { training ->
                    TrainingBox(training,
                        onClick ={navController.navigate(
                            route = "workout/"+training.id) } )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SummaryPreview() {
    AppleFitnessTheme {


    }
}