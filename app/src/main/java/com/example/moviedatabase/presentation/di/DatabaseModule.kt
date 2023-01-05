package com.example.moviedatabase.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.moviedatabase.data.db.ArtistDao
import com.example.moviedatabase.data.db.MovieDao
import com.example.moviedatabase.data.db.MoviesDb
import com.example.moviedatabase.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(application: Application): MoviesDb {
        return Room.databaseBuilder(application.applicationContext, MoviesDb::class.java, "moviesdb").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(moviesDb: MoviesDb): MovieDao {
        return moviesDb.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(moviesDb: MoviesDb): ArtistDao {
        return moviesDb.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(moviesDb: MoviesDb): TvShowDao {
        return moviesDb.tvShowDao()
    }
}