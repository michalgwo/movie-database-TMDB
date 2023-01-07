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
class GetTvShowsUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repo: TvShowRepo
    private lateinit var getTvShowsUseCase: GetTvShowsUseCase

    @Before
    fun setUp() {
        repo = FakeTvShowRepo()
        getTvShowsUseCase = GetTvShowsUseCase(repo)
    }

    @Test
    fun getTvShowsReturnsCorrectList() = runTest {
        val content = repo.updateTvShows()
        val result = getTvShowsUseCase.execute()
        Truth.assertThat(result).containsExactlyElementsIn(content)
    }
}