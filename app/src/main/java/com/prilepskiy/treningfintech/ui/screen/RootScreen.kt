package com.prilepskiy.treningfintech.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.prilepskiy.treningfintech.navigation.mainRoute
import com.prilepskiy.treningfintech.navigation.mainScreen

@Composable
fun RootScreen(
    modifier: Modifier = Modifier,
    startDestination: String = mainRoute,
) {
    val rootNavController: NavHostController = rememberNavController()
    NavHost(
        navController = rootNavController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        mainScreen()
    }
}