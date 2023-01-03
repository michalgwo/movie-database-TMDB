package com.example.moviedatabase.presentation.di.movie

import com.example.moviedatabase.presentation.di.core.ViewModelModule
import com.example.moviedatabase.presentation.movies.MoviesFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class, ViewModelModule::class])
interface MovieSubcomponent {
    fun inject(moviesFragment: MoviesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(viewModelModule: ViewModelModule): MovieSubcomponent
    }
}