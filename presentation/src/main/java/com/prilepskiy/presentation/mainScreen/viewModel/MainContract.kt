package com.prilepskiy.presentation.mainScreen.viewModel

import com.prilepskiy.mvi.MviAction
import com.prilepskiy.mvi.MviIntent
import com.prilepskiy.mvi.MviState
import javax.inject.Inject

sealed class MainIntent : MviIntent {
    data object OnClick : MainIntent()
    data class OnError(val error: String?) : MainIntent()
    data class OnLoading(val isLoading: Boolean) : MainIntent()
}

sealed class MainAction : MviAction {
    data object OnClick : MainAction()
    data class OnError(val error: String?) : MainAction()
    data class OnLoading(val isLoading: Boolean) : MainAction()
}

data class MainState(
    val text:String = "mazafaka",
    override val error: String? = null,
    override val isLoading: Boolean = false,
) : MviState