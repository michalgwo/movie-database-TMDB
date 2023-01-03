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

    fun createMovieSubcomponent(viewModelModule: ViewModelModule): MovieSubcomponent = appComponent.movieSubcomponentFactory().create(viewModelModule)
    fun createArtistSubcomponent(viewModelModule: ViewModelModule): ArtistSubcomponent = appComponent.artistSubcomponentFactory().create(viewModelModule)
    fun createTvShowSubcomponent(viewModelModule: ViewModelModule): TvShowSubcomponent = appComponent.tvShowSubcomponentFactory().create(viewModelModule)
}