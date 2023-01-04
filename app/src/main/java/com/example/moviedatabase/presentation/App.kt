package com.example.moviedatabase.presentation

import android.app.Application
import androidx.lifecycle.ViewModelStoreOwner
import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabase.presentation.di.core.*
import com.example.moviedatabase.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabase.presentation.di.tvshow.TvShowSubcomponent

class App: Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(
            BuildConfig.API_KEY,
            BuildConfig.API_BASE_URL,
            applicationContext
        )
    }

    fun createMovieSubcomponent(o: ViewModelStoreOwner): MovieSubcomponent =
        appComponent.movieSubcomponentFactory().create(o)

    fun createArtistSubcomponent(o: ViewModelStoreOwner): ArtistSubcomponent =
        appComponent.artistSubcomponentFactory().create(o)

    fun createTvShowSubcomponent(o: ViewModelStoreOwner): TvShowSubcomponent =
        appComponent.tvShowSubcomponentFactory().create(o)
}