package com.prilepskiy.domain.usecase

import com.prilepskiy.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ClearUsersUseCase @Inject constructor(
    private val repository: UserRepository, )  {

   operator fun invoke() {
        repository.clearUsers().flowOn(Dispatchers.IO)
    }
}