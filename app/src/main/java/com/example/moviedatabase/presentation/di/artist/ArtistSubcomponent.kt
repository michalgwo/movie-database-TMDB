package com.example.moviedatabase.presentation.di.artist

import com.example.moviedatabase.presentation.artists.ArtistsFragment
import com.example.moviedatabase.presentation.di.core.ViewModelModule
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class, ViewModelModule::class])
interface ArtistSubcomponent {
    fun inject(artistsFragment: ArtistsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(viewModelModule: ViewModelModule): ArtistSubcomponent
    }
}