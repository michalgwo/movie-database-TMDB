package com.example.moviedatabase.data.repos.movie

import android.util.Log
import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieCacheDataSourceInterface
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieLocalDataSourceInterface
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieRemoteDataSourceInterface
import com.example.moviedatabase.domain.repointerfaces.MovieRepoInterface

class MovieRepo(
    private val remoteDataSource: MovieRemoteDataSourceInterface,
    private val localDataSource: MovieLocalDataSourceInterface,
    private val cacheDataSource: MovieCacheDataSourceInterface
): MovieRepoInterface {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val movies = getMoviesFromApi()

        if (movies.isNotEmpty()) {
            localDataSource.deleteAllMovies()
            localDataSource.saveMovies(movies)
            cacheDataSource.saveMovies(movies)
        }
        return movies
    }

    private suspend fun getMoviesFromApi(): List<Movie> {
        val movies = ArrayList<Movie>()

        try {
            val response = remoteDataSource.getMovies()
            val body = response.body()

            if (body != null) {
                movies.addAll(body.movies)
            }
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        return movies
    }

    private suspend fun getMoviesFromDb(): List<Movie> {
        val movies = ArrayList<Movie>()

        try {
            movies.addAll(localDataSource.getMovies())
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (movies.isEmpty()) {
            movies.addAll(getMoviesFromApi())
            localDataSource.saveMovies(movies)
        }

        return movies
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        val movies = ArrayList<Movie>()

        try {
            movies.addAll(cacheDataSource.getMovies())
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (movies.isEmpty()) {
            movies.addAll(getMoviesFromDb())
            cacheDataSource.saveMovies(movies)
        }

        return movies
    }
}