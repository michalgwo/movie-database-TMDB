package com.example.moviedatabase.data.repos.tvshow.datasource

import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowCacheDataSourceInterface

class TvShowCacheDataSource: TvShowCacheDataSourceInterface {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShows(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

}