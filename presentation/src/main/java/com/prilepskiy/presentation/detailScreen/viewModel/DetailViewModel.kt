package com.prilepskiy.presentation.detailScreen.viewModel

import androidx.lifecycle.viewModelScope
import com.prilepskiy.mvi.MviBaseViewModel
import com.prilepskiy.mvi.Reducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(private val mainReducer: DetailReducer,): MviBaseViewModel<DetailState, DetailAction, DetailIntent>() {
    override var reducer: Reducer<DetailAction, DetailState> = mainReducer

    override fun initState(): DetailState = DetailState()

    override fun handleIntent(intent: DetailIntent) {
        when (intent){
            is DetailIntent.OnError -> onAction(DetailAction.OnError(intent.error))
            is DetailIntent.OnLoading -> onAction(DetailAction.OnLoading(intent.isLoading))
            is DetailIntent.OnClick -> {
                viewModelScope.launch {
                    onAction(DetailAction.OnLoading(true))
                    delay(5000)
                    onAction(DetailAction.OnClick)
                }

            }
        }
    }

}