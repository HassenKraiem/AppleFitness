package com.example.applefitness.data

class Training(
    val type:String,
    val hours:String,
    val minute:String,
    val seconds:String,
    val id:String
) {
    val cal = (1000* ((360*hours.toInt())+(60*minute.toInt())+seconds.toInt()))/(360*2)
}
