package com.prilepskiy.data.network

import com.google.gson.annotations.SerializedName
data class SmartResponse<T>(
    @SerializedName("results")
    val result: List<T>,
)