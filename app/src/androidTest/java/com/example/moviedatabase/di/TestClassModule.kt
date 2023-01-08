package com.example.moviedatabase.di

import android.app.Application
import androidx.room.Room
import com.example.moviedatabase.data.db.MoviesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestClassModule {
    @Provides
    @Named("test_db")
    fun provideInMemoryDatabase(application: Application) =
        Room.inMemoryDatabaseBuilder(
            application.applicationContext,
            MoviesDb::class.java
        ).allowMainThreadQueries().build()
}