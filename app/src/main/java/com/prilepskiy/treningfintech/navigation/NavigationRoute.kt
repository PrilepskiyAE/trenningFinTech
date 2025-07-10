package com.prilepskiy.treningfintech.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.prilepskiy.presentation.mainScreen.ui.screen.MainScreen

const val mainRoute = "main_route"
fun NavGraphBuilder.mainScreen(){
    composable(route = mainRoute) {
        MainScreen()
    }
}