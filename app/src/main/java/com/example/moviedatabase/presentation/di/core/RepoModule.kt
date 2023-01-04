package com.example.moviedatabase.presentation.di.core

import com.example.moviedatabase.data.repos.artist.ArtistRepoImpl
import com.example.moviedatabase.data.repos.movie.MovieRepoImpl
import com.example.moviedatabase.data.repos.tvshow.TvShowRepoImpl
import com.example.moviedatabase.domain.repointerfaces.ArtistRepo
import com.example.moviedatabase.domain.repointerfaces.MovieRepo
import com.example.moviedatabase.domain.repointerfaces.TvShowRepo
import dagger.Binds
import dagger.Module

@Module
abstract class RepoModule {
    @Binds
    abstract fun bindMovieRepo(impl: MovieRepoImpl): MovieRepo

    @Binds
    abstract fun bindArtistRepo(impl: ArtistRepoImpl): ArtistRepo

    @Binds
    abstract fun bindTvShowRepo(impl: TvShowRepoImpl): TvShowRepo
}