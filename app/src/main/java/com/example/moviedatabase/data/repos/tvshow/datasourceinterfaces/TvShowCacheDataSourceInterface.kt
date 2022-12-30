package com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces

import com.example.moviedatabase.data.model.tvshow.TvShow

interface TvShowCacheDataSourceInterface {
    suspend fun getTvShows(): List<TvShow>
    suspend fun saveTvShows(tvShows: List<TvShow>)
}