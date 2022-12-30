package com.example.moviedatabase.data.repos.tvshow.datasource

import com.example.moviedatabase.data.db.TvShowDao
import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.data.repos.tvshow.datasourceinterfaces.TvShowLocalDataSourceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDataSource(private val dao: TvShowDao): TvShowLocalDataSourceInterface {
    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        CoroutineScope(IO).launch {
            dao.saveTvShows(tvShows)
        }
    }

    override suspend fun deleteAllTvShows() {
        CoroutineScope(IO).launch {
            dao.deleteAllTvShows()
        }
    }

    override suspend fun getTvShows(): List<TvShow> {
       return dao.getTvShows()
    }

}