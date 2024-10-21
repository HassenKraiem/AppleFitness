package com.example.applefitness.ui


data class TimeUiState(
    val seconds:Int=0,
    val minutes:Int=1,
    val hours:Int=1,
    val startCount:Int=3,
    val timeRunning:Boolean=false
)