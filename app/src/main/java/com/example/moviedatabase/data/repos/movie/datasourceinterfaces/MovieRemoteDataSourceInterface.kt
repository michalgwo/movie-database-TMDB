package com.example.moviedatabase.data.repos.movie.datasourceinterfaces

import com.example.moviedatabase.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSourceInterface {
    suspend fun getMovies(): Response<MovieList>
}