package com.example.moviedatabase.data.repos

import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.domain.repointerfaces.MovieRepo

class FakeMovieRepo: MovieRepo {
    private var list = mutableListOf<Movie>()

    override suspend fun getMovies(): List<Movie> {
        return list
    }

    override suspend fun updateMovies(): List<Movie> {
        val newList = mutableListOf(
            Movie(false, "a", 1, "en", "Name1", "d2sad", 31.7655, "qwerty", "a", "v", false, 3.1, 5),
            Movie(true, "b", 2, "pl", "Name3", "dsafdfd", 1.6, "asdf", "d", "vggg", false, 33.1, 503),
            Movie(false, "f", 3, "es", "Name14", "fdsedsad", 31.0, "zxcv", "g", "g", true, 49.1, 8640)
        )
        list.clear()
        list.addAll(newList)
        return list
    }
}