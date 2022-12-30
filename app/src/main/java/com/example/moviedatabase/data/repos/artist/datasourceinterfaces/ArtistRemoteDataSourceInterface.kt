package com.example.moviedatabase.data.repos.artist.datasourceinterfaces

import com.example.moviedatabase.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSourceInterface {
    suspend fun getArtists(): Response<ArtistList>
}