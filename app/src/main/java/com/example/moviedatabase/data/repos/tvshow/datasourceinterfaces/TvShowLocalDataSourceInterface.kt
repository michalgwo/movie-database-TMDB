package com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces

import com.example.moviedatabase.data.model.tvshow.TvShow

interface TvShowLocalDataSourceInterface {
    suspend fun saveTvShows(tvShows: List<TvShow>)
    suspend fun deleteAllTvShows()
    suspend fun getTvShows(): List<TvShow>
}