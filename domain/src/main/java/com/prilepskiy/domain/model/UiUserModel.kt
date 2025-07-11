package com.prilepskiy.domain.model

import com.prilepskiy.common.DEFAULT_INT
import com.prilepskiy.common.DEFAULT_LONG
import com.prilepskiy.common.EMPTY_STRING
import com.prilepskiy.data.database.entity.UserEntity

data class UiUserModel(

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

fun UserEntity.toModel(): UiUserModel {
    return  UiUserModel(
        gender = this.gender,
        title = this.title,
        first = this.first,
        last = this.last,
        streetNumber = this.streetNumber,
        streetName = this.streetName,
        city = this.city,
        state = this.state,
        country = this.country,
        postcode = this.postcode,
        latitude = this.latitude,
        longitude = this.longitude,
        offset = this.offset,
        description = this.description,
        email = this.email,
        uuid = this.uuid,
        username = this.username,
        password = this.password,
        salt = this.salt,
        md5 = this.md5,
        sha1 = this.sha1,
        sha256 =this.sha256,
        dobDate = this.dobDate,
        dobAge = this.dobAge,
        registeredDate = this.registeredDate,
        registeredAge = this.registeredAge,
        phone = this.phone,
        cell = this.cell,
        nameId = this.nameId,
        valueId = this.valueId,
        large = this.large,
        medium = this.medium,
        thumbnail = this.thumbnail,
        nat = this.nat
    )
}
