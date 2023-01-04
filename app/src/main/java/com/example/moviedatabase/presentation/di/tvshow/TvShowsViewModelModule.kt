package com.example.moviedatabase.presentation.di.tvshow

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.presentation.tvshows.TvShowsViewModel
import com.example.moviedatabase.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class TvShowsViewModelModule {
    @TvShowScope
    @Provides
    fun provideTvShowsViewModel(@Named("tvShowOwner") owner: ViewModelStoreOwner, factory: TvShowsViewModelFactory): TvShowsViewModel {
        return ViewModelProvider(owner, factory)[TvShowsViewModel::class.java]
    }
}