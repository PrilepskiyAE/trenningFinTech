package com.prilepskiy.presentation.mainScreen.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.prilepskiy.common.EMPTY_STRING
import com.prilepskiy.presentation.R
import com.prilepskiy.presentation.mainScreen.viewModel.MainIntent
import com.prilepskiy.presentation.mainScreen.viewModel.MainState
import com.prilepskiy.presentation.mainScreen.viewModel.MainViewModel
import com.prilepskiy.presentation.uiComponent.ErrorMessageComponent
import com.prilepskiy.presentation.uiComponent.LoadingComponent

@Composable
fun MainScreen(goToUser: (Int) -> Unit, viewModel: MainViewModel = hiltViewModel()) {
    val state = viewModel.viewState

    if (state.isLoading) {
        LoadingComponent()
    } else if (!state.error.isNullOrEmpty()) {
        ErrorMessageComponent(textError = state.error) {
            viewModel.onIntent(MainIntent.OnClear)
        }
    } else {
        MainScreen(
            state = state,
            onClickClear = { viewModel.onIntent(MainIntent.OnClear) },
            goToUser
        )
    }

}

@Composable
private fun MainScreen(state: MainState, onClickClear: () -> Unit, goToUser: (Int) -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        LazyColumn {
            item {
                Row(Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .clickable {
                        onClickClear.invoke()
                    })  {
                    Icon(Icons.Default.Delete, contentDescription = EMPTY_STRING)
                    Text(text = stringResource(R.string.button_clear), modifier = Modifier.padding(8.dp))
                }
            }
            items(state.users) { Text("Hello ${it.first}", fontSize = 28.sp) }
        }
    }
}


