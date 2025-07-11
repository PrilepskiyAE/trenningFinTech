package com.prilepskiy.presentation.mainScreen.viewModel

import androidx.lifecycle.viewModelScope
import com.prilepskiy.common.subscribe
import com.prilepskiy.domain.usecase.ClearUsersUseCase
import com.prilepskiy.domain.usecase.GetAllUserUseCase
import com.prilepskiy.mvi.MviBaseViewModel
import com.prilepskiy.mvi.Reducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainReducer: MainReducer,
    private val clearUsersUseCase: ClearUsersUseCase,
    private val getAllUserUseCase: GetAllUserUseCase,

    ) : MviBaseViewModel<MainState, MainAction, MainIntent>() {
    override var reducer: Reducer<MainAction, MainState> = mainReducer

    override fun initState(): MainState = MainState()

    override fun handleIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.OnError -> onAction(MainAction.OnError(intent.error))
            is MainIntent.OnLoading -> onAction(MainAction.OnLoading(intent.isLoading))
            is MainIntent.OnClick -> {
                getAllUser(isNetwork = false)
            }

            is MainIntent.OnClear -> {
                clearUsersUseCase.invoke()
                getAllUser(isNetwork = true)

            }
        }
    }

    private fun getAllUser(isNetwork: Boolean) {
        getAllUserUseCase.invoke(isNetwork).subscribe(
            viewModelScope, onStart = {
                onAction(MainAction.OnLoading(true))
            }, success = {
                onAction(MainAction.GetUser(it))
            },
            error = {
                onAction(MainAction.OnError(it.message))
            }
        )
    }
}