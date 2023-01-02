package com.example.moviedatabase.presentation.di

import com.example.moviedatabase.data.repos.artist.datasource.ArtistCacheDataSource
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistCacheDataSourceInterface
import com.example.moviedatabase.data.repos.movie.datasource.MovieCacheDataSource
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieCacheDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.datasource.TvShowCacheDataSource
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowCacheDataSourceInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSourceModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSourceInterface {
        return MovieCacheDataSource()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSourceInterface {
        return ArtistCacheDataSource()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSourceInterface {
        return TvShowCacheDataSource()
    }
}