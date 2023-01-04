package com.example.moviedatabase.presentation.di.artist

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.presentation.artists.ArtistsViewModel
import com.example.moviedatabase.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ArtistsViewModelModule {
    @ArtistScope
    @Provides
    fun provideArtistsViewModel(@Named("artistOwner") owner: ViewModelStoreOwner, factory: ArtistsViewModelFactory): ArtistsViewModel {
        return ViewModelProvider(owner, factory)[ArtistsViewModel::class.java]
    }
}