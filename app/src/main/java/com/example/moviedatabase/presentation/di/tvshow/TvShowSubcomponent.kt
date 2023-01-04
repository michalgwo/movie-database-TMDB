package com.example.moviedatabase.presentation.di.tvshow

import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.presentation.tvshows.TvShowsFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@TvShowScope
@Subcomponent(modules = [TvShowsViewModelModule::class])
interface TvShowSubcomponent {
    fun inject(tvShowsFragment: TvShowsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @Named("tvShowOwner") owner: ViewModelStoreOwner): TvShowSubcomponent
    }
}