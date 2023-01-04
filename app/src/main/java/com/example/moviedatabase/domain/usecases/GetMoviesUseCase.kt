package com.example.moviedatabase.domain.usecases

import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.domain.repointerfaces.MovieRepo
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repo: MovieRepo) {
    suspend fun execute(): List<Movie>? = repo.getMovies()
}