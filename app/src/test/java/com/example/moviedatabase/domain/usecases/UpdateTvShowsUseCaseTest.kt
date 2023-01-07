package com.example.moviedatabase.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviedatabase.data.repos.FakeTvShowRepo
import com.example.moviedatabase.domain.repointerfaces.TvShowRepo
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UpdateTvShowsUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repo: TvShowRepo
    private lateinit var updateTvShowsUseCase: UpdateTvShowsUseCase

    @Before
    fun setUp() {
        repo = FakeTvShowRepo()
        updateTvShowsUseCase = UpdateTvShowsUseCase(repo)
    }

    @Test
    fun updateTvShowsReturnsCorrectList() = runTest {
        val result = updateTvShowsUseCase.execute()
        val content = repo.getTvShows()
        Truth.assertThat(content).containsExactlyElementsIn(result)
    }
}