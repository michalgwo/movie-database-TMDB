package com.example.moviedatabase.domain.usecases

import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.domain.repointerfaces.ArtistRepoInterface

class UpdateArtistsUseCase(private val repo: ArtistRepoInterface) {
    suspend fun execute(): List<Artist>? = repo.updateArtists()
}