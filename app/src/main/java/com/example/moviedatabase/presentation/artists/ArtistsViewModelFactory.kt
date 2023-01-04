package com.example.moviedatabase.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedatabase.domain.usecases.GetArtistsUseCase
import com.example.moviedatabase.domain.usecases.UpdateArtistsUseCase
import com.example.moviedatabase.presentation.di.artist.ArtistScope
import javax.inject.Inject

@ArtistScope
class ArtistsViewModelFactory @Inject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ArtistsViewModel(getArtistsUseCase, updateArtistsUseCase) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}