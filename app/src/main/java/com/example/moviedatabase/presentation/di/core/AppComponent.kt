package com.example.moviedatabase.presentation.di.core

import android.content.Context
import com.example.moviedatabase.presentation.HomeActivity
import com.example.moviedatabase.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabase.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabase.presentation.di.tvshow.TvShowSubcomponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    DatabaseModule::class,
    RemoteDataSourceModule::class,
    LocalDataSourceModule::class,
    CacheDataSourceModule::class,
    RepoModule::class
])
interface AppComponent {
    fun inject(homeActivity: HomeActivity)

    fun movieSubcomponentFactory(): MovieSubcomponent.Factory
    fun artistSubcomponentFactory(): ArtistSubcomponent.Factory
    fun tvShowSubcomponentFactory(): TvShowSubcomponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named("apiKey") apiKey: String,
            @BindsInstance @Named("apiBaseUrl") apiBaseUrl: String,
            @BindsInstance appContext: Context
        ): AppComponent
    }
}