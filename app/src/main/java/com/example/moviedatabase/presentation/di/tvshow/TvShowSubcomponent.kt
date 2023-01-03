package com.example.moviedatabase.presentation.di.tvshow

import com.example.moviedatabase.presentation.tvshows.TvShowsFragment
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubcomponent {
    fun inject(tvShowsFragment: TvShowsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubcomponent
    }
}