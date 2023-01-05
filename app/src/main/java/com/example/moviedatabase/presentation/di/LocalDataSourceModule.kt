package com.example.moviedatabase.presentation.di

import com.example.moviedatabase.data.repos.artist.datasource.ArtistLocalDataSourceImpl
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistLocalDataSource
import com.example.moviedatabase.data.repos.movie.datasource.MovieLocalDataSourceImpl
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieLocalDataSource
import com.example.moviedatabase.data.repos.tvshow.datasource.TvShowLocalDataSourceImpl
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    abstract fun bindMovieLocalDataSource(impl: MovieLocalDataSourceImpl): MovieLocalDataSource

    @Binds
    abstract fun bindArtistLocalDataSource(impl: ArtistLocalDataSourceImpl): ArtistLocalDataSource

    @Binds
    abstract fun bindTvShowLocalDataSource(impl: TvShowLocalDataSourceImpl): TvShowLocalDataSource
}