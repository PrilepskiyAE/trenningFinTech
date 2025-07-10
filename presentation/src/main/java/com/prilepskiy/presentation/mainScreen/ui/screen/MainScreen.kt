package com.prilepskiy.presentation.mainScreen.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.prilepskiy.presentation.mainScreen.viewModel.MainIntent
import com.prilepskiy.presentation.mainScreen.viewModel.MainState
import com.prilepskiy.presentation.mainScreen.viewModel.MainViewModel
import com.prilepskiy.presentation.uiComponent.TextComponent

@Composable
fun MainScreen(goToUser: (Int) -> Unit, viewModel: MainViewModel = hiltViewModel()) {
    val state = viewModel.viewState

    if (state.isLoading) {
        MainOnLoading()
    } else {
        MainScreen(
            state = state,
            onClick = { viewModel.onIntent(MainIntent.OnClick) },
            goToUser
        )
    }

}

@Composable
private fun MainScreen(state: MainState, onClick: () -> Unit, goToUser: (Int) -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextComponent(modifier = Modifier, text = state.text)
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp), onClick = onClick
            ) {
                Text("OK")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                onClick = { goToUser(99) }) {
                Text("Навигате")
            }
        }

    }
}

@Composable
private fun MainOnLoading() {
    Box(contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextComponent(modifier = Modifier, text = "Идет загрузка")
            LinearProgressIndicator()
        }
    }
}