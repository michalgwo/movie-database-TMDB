package com.example.moviedatabase.data.repos.tvshow.datasource

import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowCacheDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowCacheDataSourceImpl @Inject constructor(): TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShows(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

}