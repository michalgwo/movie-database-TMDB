package com.example.moviedatabase.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.moviedatabase.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveArtists(movies: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}