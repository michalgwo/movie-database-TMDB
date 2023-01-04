package com.example.moviedatabase.presentation.di.artist

import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.presentation.artists.ArtistsFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@ArtistScope
@Subcomponent(modules = [ArtistsViewModelModule::class])
interface ArtistSubcomponent {
    fun inject(artistsFragment: ArtistsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @Named("artistOwner") owner: ViewModelStoreOwner): ArtistSubcomponent
    }
}