package com.example.moviedatabase.presentation.di.core

import com.example.moviedatabase.presentation.HomeActivity
import com.example.moviedatabase.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabase.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabase.presentation.di.tvshow.TvShowSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RemoteDataSourceModule::class,
    LocalDataSourceModule::class,
    CacheDataSourceModule::class,
    RepoModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun inject(homeActivity: HomeActivity)

    fun movieSubcomponentFactory(): MovieSubcomponent.Factory
    fun artistSubcomponentFactory(): ArtistSubcomponent.Factory
    fun tvShowSubcomponentFactory(): TvShowSubcomponent.Factory
}