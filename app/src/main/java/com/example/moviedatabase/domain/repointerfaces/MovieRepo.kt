package com.example.moviedatabase.domain.repointerfaces

import com.example.moviedatabase.data.model.movie.Movie

interface MovieRepo {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}