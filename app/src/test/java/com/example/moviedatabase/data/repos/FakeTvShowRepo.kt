package com.example.moviedatabase.data.repos

import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.domain.repointerfaces.TvShowRepo

class FakeTvShowRepo: TvShowRepo {
    private var list = mutableListOf<TvShow>()

    override suspend fun getTvShows(): List<TvShow> {
        return list
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newList = mutableListOf(
            TvShow("false", "fdsd", 1, "RANDOM1", "en", "random1", "oasdas", 31.7, "qwrty", 2.12, 935453412),
            TvShow("dsa", "efsf0", 2, "RANDOM2", "ar", "322", "oasda51s", 35.76, "qo8wety", 0.12, 7345312),
            TvShow("444f", "0231", 3, "RANDOM3", "rr", "555", "13oasdas", 9931.6, "wery", 5.12, 4334412)
        )
        list.clear()
        list.addAll(newList)
        return list
    }
}