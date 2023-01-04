package com.example.moviedatabase.data.repos.movie.datasource

import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.movie.MovieList
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    @Named("apiKey") private val apiKey: String
    ): MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}