package com.prilepskiy.presentation.mainScreen.viewModel

import com.prilepskiy.mvi.Reducer
import javax.inject.Inject

class MainReducer @Inject constructor() : Reducer<MainAction, MainState> {
    override fun reduce(action: MainAction, state: MainState): MainState = when (action) {
        is MainAction.OnLoading-> state.copy(isLoading = action.isLoading)
        is MainAction.OnError -> state.copy(error = action.error, isLoading = false)
        is MainAction.OnClick-> state.copy(text = "Mazafaka onClick", isLoading = false)
    }
}