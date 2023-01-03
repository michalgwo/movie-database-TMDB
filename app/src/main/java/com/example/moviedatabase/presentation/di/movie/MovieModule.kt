package com.example.moviedatabase.presentation.di.movie

import com.example.moviedatabase.domain.usecases.GetMoviesUseCase
import com.example.moviedatabase.domain.usecases.UpdateMoviesUseCase
import com.example.moviedatabase.presentation.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMoviesViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                      updateMoviesUseCase: UpdateMoviesUseCase
    ): MoviesViewModelFactory {
        return MoviesViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}