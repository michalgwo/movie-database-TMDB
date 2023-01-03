package com.example.moviedatabase.presentation.di.core

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.presentation.artists.ArtistsViewModel
import com.example.moviedatabase.presentation.artists.ArtistsViewModelFactory
import com.example.moviedatabase.presentation.di.artist.ArtistScope
import com.example.moviedatabase.presentation.di.movie.MovieScope
import com.example.moviedatabase.presentation.movies.MoviesViewModel
import com.example.moviedatabase.presentation.movies.MoviesViewModelFactory
import com.example.moviedatabase.presentation.tvshows.TvShowsViewModel
import com.example.moviedatabase.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(private val owner: ViewModelStoreOwner) {
    @MovieScope
    @Provides
    fun provideMoviesViewModel(factory: MoviesViewModelFactory): MoviesViewModel {
        return ViewModelProvider(owner, factory)[MoviesViewModel::class.java]
    }

    @ArtistScope
    @Provides
    fun provideArtistsViewModel(factory: ArtistsViewModelFactory): ArtistsViewModel {
        return ViewModelProvider(owner, factory)[ArtistsViewModel::class.java]
    }

    @ArtistScope
    @Provides
    fun provideTvShowsViewModel(factory: TvShowsViewModelFactory): TvShowsViewModel {
        return ViewModelProvider(owner, factory)[TvShowsViewModel::class.java]
    }
}