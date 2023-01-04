package com.example.moviedatabase.data.repos.artist.datasourceinterfaces

import com.example.moviedatabase.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtists(): List<Artist>
    suspend fun saveArtists(artists: List<Artist>)
}