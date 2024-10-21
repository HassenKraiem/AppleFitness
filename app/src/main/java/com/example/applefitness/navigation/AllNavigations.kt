package com.example.applefitness.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.applefitness.data.Screen
import com.example.applefitness.data.DataSource
import com.example.applefitness.ui.AppViewModel
import com.example.applefitness.ui.screen.fitness.FitnessScreenContent
import com.example.applefitness.ui.screen.sharing.SharingScreenContent
import com.example.applefitness.ui.screen.summary.SummaryScreenContent
import com.example.applefitness.ui.screen.timer.TimeRunningScreenContent
import com.example.applefitness.ui.screen.workouts.WorkoutsScreenContent

@Composable
fun AllNavigation(navController: NavHostController,
                  appViewModel: AppViewModel= viewModel(),
                  modifier: Modifier=Modifier){
    NavHost(navController=navController,
        startDestination = Screen.BottomBarScreen.Sharing.route) {
        composable(route = Screen.BottomBarScreen.Sharing.route){
           SharingScreenContent(modifier)
        }
        composable(route = Screen.BottomBarScreen.Fitness.route){
            FitnessScreenContent(modifier)
        }
        composable(route = Screen.BottomBarScreen.Summary.route){
            SummaryScreenContent(modifier,navController)
        }
        composable(route =Screen.NonBottomBarScreen.WorkoutScreen.route,
            arguments = listOf(navArgument(
                name = "id"){
                type=NavType.StringType
            }
            )){
            val arg= it.arguments?.getString("id").toString()
            val training by remember {
                mutableStateOf( DataSource.listOfTraining.first{ t->
                t.id==arg })}

            WorkoutsScreenContent(training,modifier,
                onClick = {
                    navController.navigate("time")
                    appViewModel.timeSet(training)

                })


        }
        composable(route = Screen.NonBottomBarScreen.TimeRunningScreen.route) {
            it.arguments?.getString("id1").toString()
            TimeRunningScreenContent(appViewModel=appViewModel)
        }

    }

}