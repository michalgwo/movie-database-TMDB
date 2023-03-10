package com.example.moviedatabase.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.moviedatabase.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies ORDER BY popularity DESC")
    suspend fun getMovies(): List<Movie>
}