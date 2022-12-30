package com.example.moviedatabase.data.repos.artist.datasource

import com.example.moviedatabase.data.db.ArtistDao
import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistLocalDataSourceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDataSource(private val dao: ArtistDao): ArtistLocalDataSourceInterface {
    override suspend fun saveArtists(artists: List<Artist>) {
        CoroutineScope(IO).launch {
            dao.saveArtists(artists)
        }
    }

    override suspend fun deleteAllArtists() {
        CoroutineScope(IO).launch {
            dao.deleteAllArtists()
        }
    }

    override suspend fun getArtists(): List<Artist> {
        return dao.getArtists()
    }
}