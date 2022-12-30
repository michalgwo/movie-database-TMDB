package com.example.moviedatabase.data.repos.movie.datasource

import com.example.moviedatabase.data.db.MovieDao
import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieLocalDataSourceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieLocalDataSource(private val dao: MovieDao): MovieLocalDataSourceInterface {
    override suspend fun saveMovies(movies: List<Movie>) {
        CoroutineScope(IO).launch {
            dao.saveMovies(movies)
        }
    }

    override suspend fun deleteAllMovies() {
        CoroutineScope(IO).launch {
            dao.deleteAllMovies()
        }
    }

    override suspend fun getMovies(): List<Movie> {
        return dao.getMovies()
    }
}