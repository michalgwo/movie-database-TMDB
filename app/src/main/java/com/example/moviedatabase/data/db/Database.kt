package com.example.moviedatabase.data.db

import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.data.model.tvshow.TvShow

@androidx.room.Database(
    entities = [Artist::class, Movie::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class Database {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}