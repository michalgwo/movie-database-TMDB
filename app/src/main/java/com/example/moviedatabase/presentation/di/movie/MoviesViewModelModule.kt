package com.example.moviedatabase.presentation.di.movie

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.presentation.movies.MoviesViewModel
import com.example.moviedatabase.presentation.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MoviesViewModelModule {
    @MovieScope
    @Provides
    fun provideMoviesViewModel(@Named("movieOwner") owner: ViewModelStoreOwner, factory: MoviesViewModelFactory): MoviesViewModel {
        return ViewModelProvider(owner, factory)[MoviesViewModel::class.java]
    }
}