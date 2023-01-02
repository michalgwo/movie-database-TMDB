package com.example.moviedatabase.presentation.di

import com.example.moviedatabase.data.db.ArtistDao
import com.example.moviedatabase.data.db.MovieDao
import com.example.moviedatabase.data.db.TvShowDao
import com.example.moviedatabase.data.repos.artist.datasource.ArtistLocalDataSource
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistLocalDataSourceInterface
import com.example.moviedatabase.data.repos.movie.datasource.MovieLocalDataSource
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieLocalDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.datasource.TvShowLocalDataSource
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowLocalDataSourceInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(dao: MovieDao): MovieLocalDataSourceInterface {
        return MovieLocalDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(dao: ArtistDao): ArtistLocalDataSourceInterface {
        return ArtistLocalDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(dao: TvShowDao): TvShowLocalDataSourceInterface {
        return TvShowLocalDataSource(dao)
    }
}