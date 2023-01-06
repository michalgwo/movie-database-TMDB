package com.example.moviedatabase.domain.usecases

import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.domain.repointerfaces.ArtistRepo
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class UpdateArtistsUseCase @Inject constructor(private val repo: ArtistRepo) {
    suspend fun execute(): List<Artist> = repo.updateArtists()
}