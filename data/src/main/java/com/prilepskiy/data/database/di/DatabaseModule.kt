package com.prilepskiy.data.database.di

import android.content.Context
import androidx.room.Room
import com.prilepskiy.common.DATABAS_ENAME
import com.prilepskiy.data.database.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): UserDataBase =
        Room.databaseBuilder(
            context = context,
            klass = UserDataBase::class.java,
            name = DATABAS_ENAME
        ).build()
}