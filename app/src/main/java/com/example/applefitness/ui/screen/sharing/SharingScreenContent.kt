package com.example.applefitness.ui.screen.sharing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applefitness.R
import com.example.applefitness.ui.theme.AppleFitnessTheme
import com.example.applefitness.ui.theme.Green01

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharingScreenContent(modifier: Modifier) {
    Scaffold(modifier = modifier
        .padding(horizontal = 21.dp),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                ),
                title={},
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.img),
                        contentDescription = "share",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(25.dp)

                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .padding(innerPadding)

        ) {
            Text(
                text = stringResource(
                    R.string.sharing
                ),
                fontSize = 34.sp,
                lineHeight = 40.57.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
                modifier = Modifier.align(Alignment.Start),
                color = Color.White
                //textAlign = TextAlign.Start
            )
            Text(
                text = stringResource(
                    R.string.share_activity
                ),
                fontSize = 30.sp,
                lineHeight = 35.8.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                color = Color.White
            )
            Text(
                text = stringResource(
                    R.string.tap_the_button_above_to_invite_people_to_share_activity_with_you
                ),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                lineHeight = 19.09.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                color = Color.White

            )
            Text(
                text = stringResource(
                    R.string.see_how_your_data_is_managed
                ),
                fontSize = 16.sp,
                lineHeight = 19.09.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                color = Green01
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    AppleFitnessTheme {
        SharingScreenContent(Modifier)

    }
}