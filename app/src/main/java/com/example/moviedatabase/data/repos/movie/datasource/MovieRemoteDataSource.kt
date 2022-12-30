package com.example.moviedatabase.data.repos.movie.datasource

import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.movie.MovieList
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieRemoteDataSourceInterface
import retrofit2.Response

class MovieRemoteDataSource(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): MovieRemoteDataSourceInterface {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}