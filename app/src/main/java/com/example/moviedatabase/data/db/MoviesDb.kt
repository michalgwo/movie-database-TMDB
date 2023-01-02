package com.example.moviedatabase.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.data.model.tvshow.TvShow

@Database(
    entities = [Artist::class, Movie::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class MoviesDb: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}