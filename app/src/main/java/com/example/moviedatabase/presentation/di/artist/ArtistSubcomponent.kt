package com.example.moviedatabase.presentation.di.artist

import com.example.moviedatabase.presentation.artists.ArtistsFragment
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubcomponent {
    fun inject(artistsFragment: ArtistsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubcomponent
    }
}