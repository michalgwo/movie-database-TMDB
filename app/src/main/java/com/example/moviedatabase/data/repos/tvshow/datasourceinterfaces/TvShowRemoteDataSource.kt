package com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces

import com.example.moviedatabase.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}