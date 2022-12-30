package com.example.moviedatabase.data.repos.artist

import android.util.Log
import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistCacheDataSourceInterface
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistLocalDataSourceInterface
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistRemoteDataSourceInterface
import com.example.moviedatabase.domain.repointerfaces.ArtistRepoInterface

class ArtistRepo(
    private val remoteDataSource: ArtistRemoteDataSourceInterface,
    private val localDataSource: ArtistLocalDataSourceInterface,
    private val cacheDataSource: ArtistCacheDataSourceInterface
): ArtistRepoInterface {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val artists = getArtistsFromApi()
        localDataSource.deleteAllArtists()
        localDataSource.saveArtists(artists)
        cacheDataSource.saveArtists(artists)
        return artists
    }

    private suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            val response = remoteDataSource.getArtists()
            val body = response.body()

            if (body != null) {
                artists = body.artists
            }
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        return artists
    }

    private suspend fun getArtistsFromDb(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = localDataSource.getArtists()
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (artists.isEmpty()) {
            artists = getArtistsFromApi()
            localDataSource.saveArtists(artists)
        }

        return artists
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = cacheDataSource.getArtists()
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (artists.isEmpty()) {
            artists = getArtistsFromDb()
            cacheDataSource.saveArtists(artists)
        }

        return artists
    }
}