package com.example.moviedatabase.data.repos.movie.datasource

import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieCacheDataSourceInterface

class MovieCacheDataSource: MovieCacheDataSourceInterface {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMovies(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}