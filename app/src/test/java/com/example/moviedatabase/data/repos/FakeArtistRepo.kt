package com.example.moviedatabase.data.repos

import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.domain.repointerfaces.ArtistRepo

class FakeArtistRepo: ArtistRepo {
    private var list = mutableListOf<Artist>()

    override suspend fun getArtists(): List<Artist> {
        return list
    }

    override suspend fun updateArtists(): List<Artist> {
        val newList = mutableListOf(
            Artist(true, 0, 1, "ASD", "FGH", 3.76, "y"),
            Artist(true, 1, 2, "QWE", "RTY", 55.1, "g"),
            Artist(false, 1, 3, "ZXC", "VBN", 12.2, "b")
        )
        list.clear()
        list.addAll(newList)
        return list
    }
}