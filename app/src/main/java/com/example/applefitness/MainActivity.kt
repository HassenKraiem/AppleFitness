package com.example.applefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.applefitness.ui.MainScreen
import com.example.applefitness.ui.theme.AppleFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppleFitnessTheme {
                    MainScreen()
            }
        }
    }
}

