package com.example.moviedatabase.presentation.di

import com.example.moviedatabase.domain.repointerfaces.ArtistRepoInterface
import com.example.moviedatabase.domain.repointerfaces.MovieRepoInterface
import com.example.moviedatabase.domain.repointerfaces.TvShowRepoInterface
import com.example.moviedatabase.domain.usecases.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMoviesUseCase(repo: MovieRepoInterface): GetMoviesUseCase {
        return GetMoviesUseCase(repo)
    }

    @Provides
    fun provideUpdateMoviesUseCase(repo: MovieRepoInterface): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(repo)
    }

    @Provides
    fun provideGetArtistsUseCase(repo: ArtistRepoInterface): GetArtistsUseCase {
        return GetArtistsUseCase(repo)
    }

    @Provides
    fun provideUpdateArtistsUseCase(repo: ArtistRepoInterface): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(repo)
    }

    @Provides
    fun provideGetTvShowsUseCase(repo: TvShowRepoInterface): GetTvShowsUseCase {
        return GetTvShowsUseCase(repo)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(repo: TvShowRepoInterface): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(repo)
    }
}