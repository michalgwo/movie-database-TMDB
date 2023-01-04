package com.example.moviedatabase.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedatabase.domain.usecases.GetTvShowsUseCase
import com.example.moviedatabase.domain.usecases.UpdateTvShowsUseCase
import com.example.moviedatabase.presentation.di.tvshow.TvShowScope
import javax.inject.Inject

@TvShowScope
class TvShowsViewModelFactory @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}