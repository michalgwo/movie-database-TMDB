package com.example.moviedatabase.presentation.di.tvshow

import com.example.moviedatabase.domain.usecases.GetTvShowsUseCase
import com.example.moviedatabase.domain.usecases.UpdateTvShowsUseCase
import com.example.moviedatabase.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowsViewModelFactory(getTvShowsUseCase: GetTvShowsUseCase,
                                       updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowsViewModelFactory {
        return TvShowsViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}