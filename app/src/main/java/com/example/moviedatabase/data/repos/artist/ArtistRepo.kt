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
    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val artists = getArtistsFromApi()

        if (artists.isNotEmpty()) {
            localDataSource.deleteAllArtists()
            localDataSource.saveArtists(artists)
            cacheDataSource.saveArtists(artists)
        }
        return artists
    }

    private suspend fun getArtistsFromApi(): List<Artist> {
        val artists = ArrayList<Artist>()

        try {
            val response = remoteDataSource.getArtists()
            val body = response.body()

            if (body != null) {
                artists.addAll(body.artists)
            }
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        return artists
    }

    private suspend fun getArtistsFromDb(): List<Artist> {
        val artists = ArrayList<Artist>()

        try {
            artists.addAll(localDataSource.getArtists())
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (artists.isEmpty()) {
            artists.addAll(getArtistsFromApi())
            localDataSource.saveArtists(artists)
        }

        return artists
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        val artists = ArrayList<Artist>()

        try {
            artists.addAll(cacheDataSource.getArtists())
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (artists.isEmpty()) {
            artists.addAll(getArtistsFromDb())
            cacheDataSource.saveArtists(artists)
        }

        return artists
    }
}