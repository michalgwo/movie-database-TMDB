package com.example.moviedatabase.data.repos.movie.datasourceinterfaces

import com.example.moviedatabase.data.model.movie.Movie

interface MovieCacheDataSourceInterface {
    suspend fun getMovies(): List<Movie>
    suspend fun saveMovies(movies: List<Movie>)
}