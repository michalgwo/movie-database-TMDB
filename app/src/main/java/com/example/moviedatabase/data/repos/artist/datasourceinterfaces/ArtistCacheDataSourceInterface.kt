package com.example.moviedatabase.data.repos.artist.datasourceinterfaces

import com.example.moviedatabase.data.model.artist.Artist

interface ArtistCacheDataSourceInterface {
    suspend fun getArtists(): List<Artist>
    suspend fun saveArtists(artists: List<Artist>)
}