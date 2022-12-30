package com.example.moviedatabase.data.repos.tvshow.datasource

import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.tvshow.TvShowList
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSourceInterface
import retrofit2.Response

class TvShowRemoteDataSource(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSourceInterface {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}