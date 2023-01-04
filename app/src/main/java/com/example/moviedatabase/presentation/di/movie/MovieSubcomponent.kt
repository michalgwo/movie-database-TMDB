package com.example.moviedatabase.presentation.di.movie

import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.presentation.movies.MoviesFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@MovieScope
@Subcomponent(modules = [MoviesViewModelModule::class])
interface MovieSubcomponent {
    fun inject(moviesFragment: MoviesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @Named("movieOwner") owner: ViewModelStoreOwner): MovieSubcomponent
    }
}