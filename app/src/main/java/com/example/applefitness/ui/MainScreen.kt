package com.example.applefitness.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.applefitness.data.Screen
import com.example.applefitness.navigation.AllNavigation
import com.example.applefitness.ui.theme.Black03
import com.example.applefitness.ui.theme.Green01
import com.example.applefitness.ui.theme.Gris01

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val screenList= listOf(
        Screen.BottomBarScreen.Sharing.route,
        Screen.BottomBarScreen.Fitness.route,
        Screen.BottomBarScreen.Summary.route,
        Screen.NonBottomBarScreen.WorkoutScreen.route)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    if (
        currentDestination?.hierarchy?.any {
            it.route in screenList
        }==true
    ) {
        Scaffold(
            bottomBar = { BottomBar(navController = navController, modifier = Modifier) }
        ) { innerPadding ->
            AllNavigation(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
    else{
        AllNavigation(
            navController=navController,
            modifier = Modifier
        )
    }
}

@Composable
fun BottomBar(navController: NavHostController,
              modifier: Modifier=Modifier) {
    val screens = listOf(
        Screen.BottomBarScreen.Sharing,
        Screen.BottomBarScreen.Fitness,
        Screen.BottomBarScreen.Summary,
    ).reversed()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(containerColor = Black03) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                modifier = modifier
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screen.BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    modifier: Modifier=Modifier
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                painter = painterResource(screen.imageId),
                contentDescription = screen.title,
                modifier = Modifier
                    .size(24.5.dp)
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Green01,
            unselectedTextColor = Gris01,
            selectedTextColor = Green01,
            disabledIconColor = Green01,

        ),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        modifier = modifier.weight(1f)
    )
}