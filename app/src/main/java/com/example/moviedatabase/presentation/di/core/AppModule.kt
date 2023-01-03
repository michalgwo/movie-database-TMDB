package com.example.moviedatabase.presentation.di.core

import android.content.Context
import com.example.moviedatabase.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabase.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabase.presentation.di.tvshow.TvShowSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubcomponent::class, ArtistSubcomponent::class, TvShowSubcomponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return context.applicationContext
    }
}