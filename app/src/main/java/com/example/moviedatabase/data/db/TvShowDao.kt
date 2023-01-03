package com.example.moviedatabase.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.moviedatabase.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveTvShows(movies: List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tv_shows ORDER BY popularity DESC")
    suspend fun getTvShows(): List<TvShow>
}