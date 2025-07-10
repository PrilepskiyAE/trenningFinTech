package com.prilepskiy.data.network.apiservice

import com.prilepskiy.data.network.SmartResponse
import com.prilepskiy.data.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("api")
    suspend fun getUser(
        @Query("limit") limit: Int = 50,
    ): SmartResponse<UserResponse>

}