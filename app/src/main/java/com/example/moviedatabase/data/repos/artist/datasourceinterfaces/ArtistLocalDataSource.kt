package com.example.moviedatabase.data.repos.artist.datasourceinterfaces

import com.example.moviedatabase.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun saveArtists(artists: List<Artist>)
    suspend fun deleteAllArtists()
    suspend fun getArtists(): List<Artist>
}