package com.example.moviedatabase.domain.usecases

import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.domain.repointerfaces.TvShowRepoInterface

class GetTvShowsUseCase(private val repo: TvShowRepoInterface) {
    suspend fun execute(): List<TvShow>? = repo.getTvShows()
}