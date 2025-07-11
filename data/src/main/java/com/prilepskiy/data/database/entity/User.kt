package com.prilepskiy.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.common.DEFAULT_INT
import com.prilepskiy.common.DEFAULT_LONG
import com.prilepskiy.common.EMPTY_STRING


@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Long = DEFAULT_LONG,
    val gender: String = EMPTY_STRING,
    val title: String = EMPTY_STRING,
    val first: String = EMPTY_STRING,
    val last: String = EMPTY_STRING,
    val streetNumber: Int = DEFAULT_INT,
    val streetName: String = EMPTY_STRING,
    val city: String = EMPTY_STRING,
    val state: String = EMPTY_STRING,
    val country: String = EMPTY_STRING,
    val postcode: Int = DEFAULT_INT,
    val latitude: String = EMPTY_STRING,
    val longitude: String = EMPTY_STRING,
    val offset: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val email: String = EMPTY_STRING,
    val uuid: String = EMPTY_STRING,
    val username: String = EMPTY_STRING,
    val password: String = EMPTY_STRING,
    val salt: String = EMPTY_STRING,
    val md5: String = EMPTY_STRING,
    val sha1: String = EMPTY_STRING,
    val sha256: String = EMPTY_STRING,
    val dobDate: String = EMPTY_STRING,
    val dobAge: Int = DEFAULT_INT,
    val registeredDate: String = EMPTY_STRING,
    val registeredAge: Int = DEFAULT_INT,
    val phone: String = EMPTY_STRING,
    val cell: String = EMPTY_STRING,
    val nameId: String = EMPTY_STRING,
    val valueId: String = EMPTY_STRING,
    val large: String = EMPTY_STRING,
    val medium: String = EMPTY_STRING,
    val thumbnail: String = EMPTY_STRING,
    val nat: String = EMPTY_STRING
)
