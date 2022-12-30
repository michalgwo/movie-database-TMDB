package com.example.moviedatabase.data.repos.tvshow

import android.util.Log
import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowCacheDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowLocalDataSourceInterface
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSourceInterface
import com.example.moviedatabase.domain.repointerfaces.TvShowRepoInterface

class TvShowRepo(
    private val remoteDataSource: TvShowRemoteDataSourceInterface,
    private val localDataSource: TvShowLocalDataSourceInterface,
    private val cacheDataSource: TvShowCacheDataSourceInterface
): TvShowRepoInterface {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val tvShows = getTvShowsFromApi()
        localDataSource.deleteAllTvShows()
        localDataSource.saveTvShows(tvShows)
        cacheDataSource.saveTvShows(tvShows)
        return tvShows
    }

    private suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShows: List<TvShow>

        try {
            val response = remoteDataSource.getTvShows()
            val body = response.body()

            if (body != null) {
                tvShows = body.tvShows
            }
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        return tvShows
    }

    private suspend fun getTvShowsFromDb(): List<TvShow> {
        lateinit var tvShows: List<TvShow>

        try {
            tvShows = localDataSource.getTvShows()
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (tvShows.isEmpty()) {
            tvShows = getTvShowsFromApi()
            localDataSource.saveTvShows(tvShows)
        }

        return tvShows
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShows: List<TvShow>

        try {
            tvShows = cacheDataSource.getTvShows()
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (tvShows.isEmpty()) {
            tvShows = getTvShowsFromDb()
            cacheDataSource.saveTvShows(tvShows)
        }

        return tvShows
    }
}