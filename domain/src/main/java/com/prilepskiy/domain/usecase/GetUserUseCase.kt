package com.prilepskiy.domain.usecase

import com.prilepskiy.common.CoroutineDispatcherProvider
import com.prilepskiy.data.repository.UserRepository
import com.prilepskiy.domain.model.UiUserModel
import com.prilepskiy.domain.model.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class GetUserUseCase @Inject constructor(
    private val repository: UserRepository,
    private val dispatcher: CoroutineDispatcherProvider
)  {
   operator fun invoke(userId: Long): Flow<UiUserModel?> {
        return repository.getUser(userId).flowOn(dispatcher.io).map { it?.toModel() }
    }
}