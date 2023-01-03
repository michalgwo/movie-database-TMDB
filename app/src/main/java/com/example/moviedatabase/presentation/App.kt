package com.example.moviedatabase.presentation

import android.app.Application
import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabase.presentation.di.core.*
import com.example.moviedatabase.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabase.presentation.di.tvshow.TvShowSubcomponent

class App: Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.API_BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()
    }

    fun createMovieSubcomponent(): MovieSubcomponent = appComponent.movieSubcomponentFactory().create()
    fun createArtistSubcomponent(): ArtistSubcomponent = appComponent.artistSubcomponentFactory().create()
    fun createTvShowSubcomponent(): TvShowSubcomponent = appComponent.tvShowSubcomponentFactory().create()
}