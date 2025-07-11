package com.prilepskiy.presentation.detailScreen.viewModel

import androidx.lifecycle.viewModelScope
import com.prilepskiy.common.subscribe
import com.prilepskiy.domain.usecase.GetUserUseCase
import com.prilepskiy.mvi.MviBaseViewModel
import com.prilepskiy.mvi.Reducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailReducer: DetailReducer,
    private val getUserUseCase: GetUserUseCase
) : MviBaseViewModel<DetailState, DetailAction, DetailIntent>() {
    override var reducer: Reducer<DetailAction, DetailState> = detailReducer

    override fun initState(): DetailState = DetailState()

    override fun handleIntent(intent: DetailIntent) {
        when (intent) {
            is DetailIntent.OnError -> onAction(DetailAction.OnError(intent.error))
            is DetailIntent.OnLoading -> onAction(DetailAction.OnLoading(intent.isLoading))
            is DetailIntent.GetUser -> {
                getUserUseCase.invoke(intent.userId.toLong()).subscribe(
                    viewModelScope, onStart = {
                        onAction(DetailAction.OnLoading(true))
                    },
                    success = {
                        if (it != null) {
                            onAction(DetailAction.GetUser(it))
                        } else {
                            onAction(DetailAction.OnError("User not found"))
                        }
                    },
                    error = {
                        onAction(DetailAction.OnError(it.message))
                    }
                )
            }
        }
    }
}

