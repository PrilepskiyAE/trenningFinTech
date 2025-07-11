package com.prilepskiy.data.repository

import com.prilepskiy.common.emitFlow
import com.prilepskiy.data.database.dao.UserDao
import com.prilepskiy.data.database.entity.UserEntity

import com.prilepskiy.data.network.apiservice.UserService
import com.prilepskiy.data.network.response.toEntity

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val dao: UserDao,
    private val userService: UserService
)  {

     fun getUser(userId: Long): Flow<UserEntity?> = emitFlow {
        dao.getUser(userId).firstOrNull()
    }

    fun getAllUser(isNetwork: Boolean): Flow<List<UserEntity>> = emitFlow {
        val resultDatabase = dao.getAll()
        if (isNetwork || resultDatabase.isEmpty()) {
            userService.getUser().result.map { userResponse ->
                dao.insert(userEntity = userResponse.toEntity())
            }
            dao.getAll()
        } else resultDatabase

    }

     fun clearUsers() = emitFlow {
        dao.deleteAll()
    }

}