package com.example.moviedatabase.data.repos.artist.datasource

import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.artist.ArtistList
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistRemoteDataSourceInterface
import retrofit2.Response

class ArtistRemoteDataSource(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): ArtistRemoteDataSourceInterface {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}