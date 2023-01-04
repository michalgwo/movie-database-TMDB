package com.example.moviedatabase.data.repos.tvshow

import android.util.Log
import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowCacheDataSource
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowLocalDataSource
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowRemoteDataSource
import com.example.moviedatabase.domain.repointerfaces.TvShowRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepoImpl @Inject constructor(
    private val remoteDataSource: TvShowRemoteDataSource,
    private val localDataSource: TvShowLocalDataSource,
    private val cacheDataSource: TvShowCacheDataSource
): TvShowRepo {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val tvShows = getTvShowsFromApi()

        if (tvShows.isNotEmpty()) {
            localDataSource.deleteAllTvShows()
            localDataSource.saveTvShows(tvShows)
            cacheDataSource.saveTvShows(tvShows)
        }
        return tvShows
    }

    private suspend fun getTvShowsFromApi(): List<TvShow> {
        val tvShows = ArrayList<TvShow>()

        try {
            val response = remoteDataSource.getTvShows()
            val body = response.body()

            if (body != null) {
                tvShows.addAll(body.tvShows)
            }
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        return tvShows
    }

    private suspend fun getTvShowsFromDb(): List<TvShow> {
        val tvShows = ArrayList<TvShow>()

        try {
            tvShows.addAll(localDataSource.getTvShows())
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (tvShows.isEmpty()) {
            tvShows.addAll(getTvShowsFromApi())
            localDataSource.saveTvShows(tvShows)
        }

        return tvShows
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        val tvShows = ArrayList<TvShow>()

        try {
            tvShows.addAll(cacheDataSource.getTvShows())
        } catch (e: Exception) {
            Log.d("MyTag", "Error: ${e.message}")
        }

        if (tvShows.isEmpty()) {
            tvShows.addAll(getTvShowsFromDb())
            cacheDataSource.saveTvShows(tvShows)
        }

        return tvShows
    }
}