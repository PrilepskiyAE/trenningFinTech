package com.prilepskiy.presentation.mainScreen.viewModel

import com.prilepskiy.domain.model.UiUserModel
import com.prilepskiy.mvi.MviAction
import com.prilepskiy.mvi.MviIntent
import com.prilepskiy.mvi.MviState
import javax.inject.Inject

sealed class MainIntent : MviIntent {
    data class OnClick(val userId:Int) : MainIntent()
    data class OnError(val error: String?) : MainIntent()
    data object OnClear : MainIntent()
    data class OnLoading(val isLoading: Boolean) : MainIntent()
}

sealed class MainAction : MviAction {
    data class GetUser(val users: List<UiUserModel>) : MainAction()
    data class OnError(val error: String?) : MainAction()
    data class OnLoading(val isLoading: Boolean) : MainAction()
}

data class MainState(
    val users:List<UiUserModel> = listOf(),
    override val error: String? = null,
    override val isLoading: Boolean = false,
) : MviState