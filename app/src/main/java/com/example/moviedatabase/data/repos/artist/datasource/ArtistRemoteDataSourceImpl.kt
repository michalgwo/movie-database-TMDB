package com.example.moviedatabase.data.repos.artist.datasource

import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.artist.ArtistList
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class ArtistRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    @Named("apiKey") private val apiKey: String
    ): ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}