package com.example.moviedatabase.domain.repointerfaces

import com.example.moviedatabase.data.model.artist.Artist

interface ArtistRepo {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}