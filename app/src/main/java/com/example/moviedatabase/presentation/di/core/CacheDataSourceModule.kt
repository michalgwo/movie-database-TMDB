package com.example.moviedatabase.presentation.di.core

import com.example.moviedatabase.data.repos.artist.datasource.ArtistCacheDataSourceImpl
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistCacheDataSource
import com.example.moviedatabase.data.repos.movie.datasource.MovieCacheDataSourceImpl
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieCacheDataSource
import com.example.moviedatabase.data.repos.tvshow.datasource.TvShowCacheDataSourceImpl
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowCacheDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class CacheDataSourceModule {
    @Binds
    abstract fun bindMovieCacheDataSource(impl: MovieCacheDataSourceImpl): MovieCacheDataSource

    @Binds
    abstract fun bindArtistCacheDataSource(impl: ArtistCacheDataSourceImpl): ArtistCacheDataSource

    @Binds
    abstract fun bindTvShowCacheDataSource(impl: TvShowCacheDataSourceImpl): TvShowCacheDataSource
}