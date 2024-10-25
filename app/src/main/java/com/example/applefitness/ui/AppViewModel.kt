package com.example.applefitness.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.applefitness.data.Training
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel :ViewModel() {

    private val _timeUiState= MutableStateFlow(TimeUiState())
    val timeUiState:StateFlow<TimeUiState> = _timeUiState.asStateFlow()
    fun timeSet(training: Training){
        _timeUiState.update { currentState->
            currentState.copy(
                seconds = training.seconds.toInt(),
                minutes = training.minute.toInt(),
                hours = training.hours.toInt(),
                startCount = 3
            )
        }
        initialHours=_timeUiState.value.hours
        initialMinutes = _timeUiState.value.minutes
        initialSeconds=_timeUiState.value.seconds
    }

    private var initialHours=_timeUiState.value.hours
    private var initialMinutes = _timeUiState.value.minutes
    private var initialSeconds=_timeUiState.value.seconds


   suspend fun countDownTimer(){
       while (_timeUiState.value.hours!=0 || _timeUiState.value.minutes!=0 || _timeUiState.value.seconds!=0){
           if (_timeUiState.value.minutes==0 && _timeUiState.value.seconds==0 ){
               _timeUiState.update { currentUiState->
                   currentUiState.copy(
                       hours = currentUiState.hours-1
                   )
               }
               _timeUiState.update {currentState->
                   currentState.copy(
                       minutes = 59
                   )
               }
               _timeUiState.update {currentState->
                   currentState.copy(
                       seconds = 59
                   )
               }
           }
           if (_timeUiState.value.seconds==0){
               _timeUiState.update { currentState->
                   currentState.copy(
                       minutes = currentState.minutes-1
                   )
               }
               _timeUiState.update {currentState->
                   currentState.copy(
                       seconds = 59
                   )
               }
           }
           delay(1000L)
           _timeUiState.update {currentState->
               currentState.copy(
                   seconds = currentState.seconds-1
               )
           }
       }
    }
    fun reset(){
        _timeUiState.update {currentState->
            currentState.copy(
                seconds = initialSeconds,
                minutes = initialMinutes,
                hours = initialHours
            )
        }
        timeRunning=false
    }
    fun plus(){
        _timeUiState.update {currentState->
            currentState.copy(
                seconds = currentState.seconds+5
            )
        }
        if (_timeUiState.value.seconds>=60){
            _timeUiState.update { currentState->
                currentState.copy(
                    seconds = currentState.seconds-60,
                    minutes = currentState.minutes+1
                )
            }
        }
        if (_timeUiState.value.minutes>=60){
            _timeUiState.update {currentState->
                currentState.copy(
                    minutes = currentState.minutes-60,
                    hours = currentState.hours+1
                )
            }
        }
    }
    fun minus(){
        _timeUiState.update {currentState->
            currentState.copy(
                seconds = currentState.seconds-5
            )
        }
        if (_timeUiState.value.seconds<0){
            _timeUiState.update { currentState->
                currentState.copy(
                    seconds = currentState.seconds+60,
                    minutes = currentState.minutes-1
                )
            }
        }
        if (_timeUiState.value.minutes<0){
            _timeUiState.update {currentState->
                currentState.copy(
                    minutes = currentState.minutes+60,
                    hours = currentState.hours-1
                )
            }
        }
    }
    suspend fun startCountDown(){
        while (_timeUiState.value.startCount!=-1) {
            delay(1000L)
            _timeUiState.update { currentState ->
                currentState.copy(
                    startCount = currentState.startCount - 1
                )
            }
        }
    }
    var timeRunning by mutableStateOf(false)
    fun changeTimeState(){
        timeRunning=!timeRunning
    }



}