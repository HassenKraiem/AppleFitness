package com.example.applefitness.ui.screen.timer

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applefitness.R
import com.example.applefitness.ui.AppViewModel
import com.example.applefitness.ui.theme.Green01
import com.example.applefitness.ui.theme.Green02
import com.example.applefitness.ui.theme.Red01
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun TimeRunningScreenContent(
    appViewModel: AppViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    var timeRunning by remember { mutableStateOf(false) }
    val timeUiState by appViewModel.timeUiState.collectAsState()

    LaunchedEffect(timeUiState) {
        launch {
            appViewModel.startCountDown()
        }
    }
    if (timeRunning) {
        LaunchedEffect(timeUiState) {
            coroutineScope {
                launch {
                    appViewModel.countDownTimer()
                }

            }
            timeRunning = false
        }
    }
    Scaffold(modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                ),
                title = {
                    Text(
                        text = "Strength Training",
                        fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                        fontSize = 18.sp,
                        lineHeight = 21.48.sp,
                        color = Color.White,
                    )
                },
                navigationIcon = {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "return",
                            tint = Green01
                        )
                        Text(
                            text = "Summary",
                            fontFamily = FontFamily(Font(R.font.sf_pro_regular)),
                            fontSize = 16.sp,
                            lineHeight = 19.09.sp,
                            color = Green01
                        )
                    }
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.share_up),
                        contentDescription = "share",
                        tint = Green01
                    )

                }

            )
        }) { innerPadding ->

        if (timeUiState.startCount != 0) {
            val infiniteTransition= rememberInfiniteTransition(label = "")
            val angle by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                ), label = ""
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
                    .padding(innerPadding)
            ) {

                Text(
                    text = timeUiState.startCount.toString(),
                    color = Color.White,
                    fontSize = 80.sp
                )
                Canvas(
                    modifier = Modifier
                        .size(259.dp),
                ) {
                    drawCircle(
                        color = Green01,
                        style = Stroke(width = 50f)
                    )

                }
                Canvas(
                    modifier = Modifier
                        .size(259.dp),
                ) {
                    drawArc(
                        color = Green02,
                        style = Stroke(width = 50f,
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round),
                        startAngle = angle,
                        sweepAngle = 360/4f,
                        useCenter = false
                    )

                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val stringHours = if (timeUiState.hours < 10) "0${timeUiState.hours}"
                else timeUiState.hours.toString()
                val stringMinutes = if (timeUiState.minutes < 10) "0${timeUiState.minutes}"
                else timeUiState.minutes.toString()
                val stringSeconds = if (timeUiState.seconds < 10) "0${timeUiState.seconds}"
                else timeUiState.seconds.toString()
                Spacer(Modifier.height(136.dp))
                Row {
                    AnimatedContent(
                        targetState = stringHours, transitionSpec = { addAnimation() },
                        label = ""
                    ) {
                        Text(
                            text = "$it:",
                            fontSize = 100.sp,
                            color = Color.White,
                            modifier = Modifier
                        )
                    }
                    AnimatedContent(
                        targetState = stringMinutes, transitionSpec = { addAnimation() },
                        label = ""
                    ) {
                        Text(
                            text = "$it:",
                            fontSize = 100.sp,
                            color = Color.White,
                            modifier = Modifier
                        )
                    }
                    AnimatedContent(
                        targetState = stringSeconds, transitionSpec = { addAnimation() },
                        label = ""
                    ) {
                        Text(
                            text = it,
                            fontSize = 100.sp,
                            color = Color.White,
                            modifier = Modifier
                        )
                    }
                }
                Spacer(Modifier.height(167.dp))
                if (!timeRunning) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(74.dp)
                            .clip(shape = RoundedCornerShape(50.dp))
                            .background(color = Green02)
                            .padding(9.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.polygon_4__1_),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
                Spacer(Modifier.height(82.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(110.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.minus),
                        contentDescription = "minus",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = RoundedCornerShape(50.dp))
                            .background(color = Red01)
                            .padding(9.dp)
                            .clickable {
                                appViewModel.minus()
                            }

                    )
                    Icon(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = "plus",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = RoundedCornerShape(50.dp))
                            .background(color = Red01)
                            .padding(9.dp)
                            .clickable {
                                appViewModel.plus()
                            }

                    )
                }
                Spacer(Modifier.height(35.dp))
                Row(
                    modifier = Modifier.height(53.dp)
                ) {
                    Button(
                        onClick = if (!timeRunning) {
                            { timeRunning = true }
                        } else {
                            { timeRunning = false }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Green01
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .height(53.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        Text(
                            text = if (timeRunning) "Pause" else "start",
                            fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
                            fontSize = 18.sp,
                            lineHeight = 21.48.sp
                        )
                    }
                    Button(
                        onClick = {
                            appViewModel.reset()
                            timeRunning = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Green01
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .height(53.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        Text(
                            text = "Reset",
                            fontFamily = FontFamily(Font(R.font.sf_pro_bold)),
                            fontSize = 18.sp,
                            lineHeight = 21.48.sp
                        )
                    }
                }
                Spacer(Modifier.height(60.dp))

            }
        }

    }
}

@ExperimentalAnimationApi
fun addAnimation(duration: Int = 600): ContentTransform {
    return (slideInVertically(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeIn(
        animationSpec = tween(durationMillis = duration)
    )).togetherWith(slideOutVertically(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeOut(
        animationSpec = tween(durationMillis = duration)
    ))
}
