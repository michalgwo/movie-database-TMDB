package com.example.moviedatabase.data.repos.movie.datasourceinterfaces

import com.example.moviedatabase.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun saveMovies(movies: List<Movie>)
    suspend fun deleteAllMovies()
    suspend fun getMovies(): List<Movie>
}