package com.example.moviedatabase.data.repos.tvshow.datasource

import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.tvshow.TvShowList
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
    ): TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> =
        tmdbService.getPopularTvShows(BuildConfig.API_KEY)
}