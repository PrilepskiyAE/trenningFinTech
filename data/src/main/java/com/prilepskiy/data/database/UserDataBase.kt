package com.prilepskiy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prilepskiy.common.VERSION_DATABASE
import com.prilepskiy.data.database.dao.UserDao
import com.prilepskiy.data.database.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
    ],
    version = VERSION_DATABASE
)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}