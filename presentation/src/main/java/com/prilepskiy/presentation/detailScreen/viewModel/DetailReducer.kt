package com.prilepskiy.presentation.detailScreen.viewModel

import com.prilepskiy.mvi.Reducer
import javax.inject.Inject

class DetailReducer @Inject constructor() : Reducer<DetailAction, DetailState> {
    override fun reduce(action: DetailAction, state: DetailState): DetailState = when (action) {
        is DetailAction.OnLoading-> state.copy(isLoading = action.isLoading)
        is DetailAction.OnError -> state.copy(error = action.error, isLoading = false)
        is DetailAction.GetUser -> state.copy(userModel = action.userModel ,isLoading = false)
    }
}