package com.example.moviedatabase.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedatabase.domain.usecases.GetMoviesUseCase
import com.example.moviedatabase.domain.usecases.UpdateMoviesUseCase
import com.example.moviedatabase.presentation.di.movie.MovieScope
import javax.inject.Inject

@MovieScope
class MoviesViewModelFactory @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoviesViewModel(getMoviesUseCase, updateMoviesUseCase) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}