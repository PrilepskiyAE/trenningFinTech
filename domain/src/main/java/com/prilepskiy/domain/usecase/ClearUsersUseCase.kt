package com.prilepskiy.domain.usecase

import com.prilepskiy.common.CoroutineDispatcherProvider
import com.prilepskiy.data.repository.UserRepository
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ClearUsersUseCase @Inject constructor(
    private val repository: UserRepository, private val dispatcher: CoroutineDispatcherProvider
)  {

   operator fun invoke() {
        repository.clearUsers().flowOn(dispatcher.io)
    }
}