package com.example.moviedatabase.domain.repointerfaces

import com.example.moviedatabase.data.model.tvshow.TvShow

interface TvShowRepoInterface {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}