package com.example.moviedatabase.presentation.di

import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.repos.artist.datasource.ArtistRemoteDataSource
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistRemoteDataSourceInterface
import com.example.moviedatabase.data.repos.movie.datasource.MovieRemoteDataSource
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieRemoteDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSourceInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSourceInterface {
        return MovieRemoteDataSource(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSourceInterface {
        return ArtistRemoteDataSource(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSourceInterface {
        return TvShowRemoteDataSource(tmdbService, apiKey)
    }
}