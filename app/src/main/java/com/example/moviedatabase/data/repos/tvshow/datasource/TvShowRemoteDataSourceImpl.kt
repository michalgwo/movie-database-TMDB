package com.example.moviedatabase.data.repos.tvshow.datasource

import com.example.moviedatabase.data.api.TMDBService
import com.example.moviedatabase.data.model.tvshow.TvShowList
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    @Named("apiKey") private val apiKey: String
): TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}