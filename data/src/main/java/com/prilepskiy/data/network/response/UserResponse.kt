package com.prilepskiy.data.network.response

import com.google.gson.annotations.SerializedName
import com.prilepskiy.common.DEFAULT_INT
import com.prilepskiy.common.EMPTY_STRING
import com.prilepskiy.data.database.entity.UserEntity

data class Name(
    @SerializedName("title")
    val title: String?,
    @SerializedName("first")
    val first: String?,
    @SerializedName("last")
    val last: String?
)

data class Street(
    @SerializedName("number")
    val number: Int?,
    @SerializedName("name")
    val name: String?
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longitude")
    val longitude: String?
)

data class Timezone(
    @SerializedName("offset")
    val offset: String?,
    @SerializedName("description")
    val description: String?
)

data class Location(
    @SerializedName("street")
    val street: Street?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("postcode")
    val postcode: Int?,
    @SerializedName("coordinates")
    val coordinates: Coordinates?,
    @SerializedName("timezone")
    val timezone: Timezone?
)

data class Login(
    @SerializedName("uuid")
    val uuid: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("salt")
    val salt: String?,
    @SerializedName("md5")
    val md5: String?,
    @SerializedName("sha1")
    val sha1: String?,
    @SerializedName("sha256")
    val sha256: String?
)

data class Dob(
    @SerializedName("date")
    val date: String?,
    @SerializedName("age")
    val age: Int?
)

data class Registered(
    @SerializedName("date")
    val date: String?,
    @SerializedName("age")
    val age: Int?
)

data class Id(
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?
)

data class Picture(
    @SerializedName("large")
    val large: String?,
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)

data class UserResponse(
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("name")
    val name: Name?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("login")
    val login: Login?,
    @SerializedName("dob")
    val dob: Dob?,
    @SerializedName("registered")
    val registered: Registered?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("cell")
    val cell: String?,
    @SerializedName("id")
    val id: Id?,
    @SerializedName("picture")
    val picture: Picture?,
    @SerializedName("nat")
    val nat: String?
)

fun UserResponse.toEntity():UserEntity{
return UserEntity(
        gender = this.gender?: EMPTY_STRING,
        title = this.name?.title?: EMPTY_STRING,
        first = this.name?.first?: EMPTY_STRING,
        last = this.name?.last?: EMPTY_STRING,
        streetNumber = this.location?.street?.number?: DEFAULT_INT,
        streetName = this.location?.street?.name?: EMPTY_STRING,
        city = this.location?.city?: EMPTY_STRING,
        state = this.location?.state?: EMPTY_STRING,
        country = this.location?.country?: EMPTY_STRING,
        postcode = this.location?.postcode?: DEFAULT_INT,
        latitude = this.location?.coordinates?.latitude?: EMPTY_STRING,
        longitude = this.location?.coordinates?.longitude?: EMPTY_STRING,
        offset = this.location?.timezone?.offset?: EMPTY_STRING,
        description = this.location?.timezone?.description?: EMPTY_STRING,
        email = this.email?: EMPTY_STRING,
        uuid = this.login?.uuid?: EMPTY_STRING,
        username = this.login?.username?: EMPTY_STRING,
        password = this.login?.password?: EMPTY_STRING,
        salt = this.login?.salt?: EMPTY_STRING,
        md5 = this.login?.md5?: EMPTY_STRING,
        sha1 = this.login?.sha1?: EMPTY_STRING,
        sha256 =this.login?.sha256?: EMPTY_STRING,
        dobDate = this.dob?.date?: EMPTY_STRING,
        dobAge = this.dob?.age?: DEFAULT_INT,
        registeredDate = this.registered?.date?: EMPTY_STRING,
        registeredAge = this.registered?.age?: DEFAULT_INT,
        phone = this.phone?: EMPTY_STRING,
        cell = this.cell?: EMPTY_STRING,
        nameId = this.id?.name?:EMPTY_STRING,
        valueId = this.id?.value?: EMPTY_STRING,
        large = this.picture?.large?: EMPTY_STRING,
        medium = this.picture?.medium?: EMPTY_STRING,
        thumbnail = this.picture?.thumbnail?: EMPTY_STRING,
        nat = this.nat?: EMPTY_STRING
    )
}

