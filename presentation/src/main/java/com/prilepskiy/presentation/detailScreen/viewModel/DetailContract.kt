package com.prilepskiy.presentation.detailScreen.viewModel

import com.prilepskiy.domain.model.UiUserModel
import com.prilepskiy.mvi.MviAction
import com.prilepskiy.mvi.MviIntent
import com.prilepskiy.mvi.MviState

sealed class DetailIntent : MviIntent {
    data class GetUser(val userId:Int) : DetailIntent()
    data class OnError(val error: String?) : DetailIntent()
    data class OnLoading(val isLoading: Boolean) : DetailIntent()
}

sealed class DetailAction : MviAction {
    data class GetUser(val userModel: UiUserModel) : DetailAction()
    data class OnError(val error: String?) : DetailAction()
    data class OnLoading(val isLoading: Boolean) : DetailAction()
}

data class DetailState(
    val userModel: UiUserModel=UiUserModel(),
    override val error: String? = null,
    override val isLoading: Boolean = false,
) : MviState