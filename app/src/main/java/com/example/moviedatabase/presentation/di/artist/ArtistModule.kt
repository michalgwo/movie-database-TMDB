package com.example.moviedatabase.presentation.di.artist

import com.example.moviedatabase.domain.usecases.GetArtistsUseCase
import com.example.moviedatabase.domain.usecases.UpdateArtistsUseCase
import com.example.moviedatabase.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistsViewModelFactory(getArtistsUseCase: GetArtistsUseCase,
                                       updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}