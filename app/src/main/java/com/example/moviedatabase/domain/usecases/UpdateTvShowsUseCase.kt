package com.example.moviedatabase.domain.usecases

import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.domain.repointerfaces.TvShowRepo
import javax.inject.Inject

class UpdateTvShowsUseCase @Inject constructor(private val repo: TvShowRepo) {
    suspend fun execute(): List<TvShow>? = repo.updateTvShows()
}