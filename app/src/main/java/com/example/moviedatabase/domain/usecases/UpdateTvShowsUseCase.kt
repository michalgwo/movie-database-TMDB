package com.example.moviedatabase.domain.usecases

import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.domain.repointerfaces.TvShowRepo
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class UpdateTvShowsUseCase @Inject constructor(private val repo: TvShowRepo) {
    suspend fun execute(): List<TvShow> = repo.updateTvShows()
}