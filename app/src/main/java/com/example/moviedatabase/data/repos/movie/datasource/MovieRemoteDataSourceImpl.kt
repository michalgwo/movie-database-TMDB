package com.example.moviedatabase.data.repos.movie.datasource

import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.movie.MovieList
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
    ): MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(BuildConfig.API_KEY)
}