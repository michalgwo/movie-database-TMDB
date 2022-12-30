package com.example.moviedatabase.domain.usecases

import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.domain.repointerfaces.MovieRepoInterface

class UpdateMoviesUseCase(private val repo: MovieRepoInterface) {
    suspend fun execute(): List<Movie>? = repo.updateMovies()
}