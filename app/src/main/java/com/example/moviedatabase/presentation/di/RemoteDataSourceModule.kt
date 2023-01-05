package com.example.moviedatabase.presentation.di

import com.example.moviedatabase.data.repos.artist.datasource.ArtistRemoteDataSourceImpl
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistRemoteDataSource
import com.example.moviedatabase.data.repos.movie.datasource.MovieRemoteDataSourceImpl
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieRemoteDataSource
import com.example.moviedatabase.data.repos.tvshow.datasource.TvShowRemoteDataSourceImpl
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindMovieRemoteDataSource(impl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    abstract fun bindArtistRemoteDataSource(impl: ArtistRemoteDataSourceImpl): ArtistRemoteDataSource

    @Binds
    abstract fun bindTvShowRemoteDataSource(impl: TvShowRemoteDataSourceImpl): TvShowRemoteDataSource
}