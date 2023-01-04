package com.example.moviedatabase.data.repos.artist.datasource

import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistCacheDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistCacheDataSourceImpl @Inject constructor(): ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtists(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtists(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}