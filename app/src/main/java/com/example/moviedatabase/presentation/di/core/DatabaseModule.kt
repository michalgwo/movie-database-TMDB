package com.example.moviedatabase.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.moviedatabase.data.db.ArtistDao
import com.example.moviedatabase.data.db.MovieDao
import com.example.moviedatabase.data.db.MoviesDb
import com.example.moviedatabase.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): MoviesDb {
        return Room.databaseBuilder(context, MoviesDb::class.java, "moviesdb").build()
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