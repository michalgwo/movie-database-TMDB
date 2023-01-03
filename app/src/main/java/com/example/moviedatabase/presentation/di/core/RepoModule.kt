package com.example.moviedatabase.presentation.di.core

import com.example.moviedatabase.data.repos.artist.ArtistRepo
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistCacheDataSourceInterface
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistLocalDataSourceInterface
import com.example.moviedatabase.data.repos.artist.datasourceinterfaces.ArtistRemoteDataSourceInterface
import com.example.moviedatabase.data.repos.movie.MovieRepo
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieCacheDataSourceInterface
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieLocalDataSourceInterface
import com.example.moviedatabase.data.repos.movie.datasourceinterfaces.MovieRemoteDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.TvShowRepo
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowCacheDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowLocalDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSourceInterface
import com.example.moviedatabase.domain.repointerfaces.ArtistRepoInterface
import com.example.moviedatabase.domain.repointerfaces.MovieRepoInterface
import com.example.moviedatabase.domain.repointerfaces.TvShowRepoInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun provideMovieRepo(remoteDataSource: MovieRemoteDataSourceInterface,
                         localDataSource: MovieLocalDataSourceInterface,
                         cacheDataSource: MovieCacheDataSourceInterface
    ): MovieRepoInterface {
        return MovieRepo(remoteDataSource, localDataSource, cacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepo(remoteDataSource: ArtistRemoteDataSourceInterface,
                          localDataSource: ArtistLocalDataSourceInterface,
                          cacheDataSource: ArtistCacheDataSourceInterface
    ): ArtistRepoInterface {
        return ArtistRepo(remoteDataSource, localDataSource, cacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepo(remoteDataSource: TvShowRemoteDataSourceInterface,
                          localDataSource: TvShowLocalDataSourceInterface,
                          cacheDataSource: TvShowCacheDataSourceInterface
    ): TvShowRepoInterface {
        return TvShowRepo(remoteDataSource, localDataSource, cacheDataSource)
    }
}