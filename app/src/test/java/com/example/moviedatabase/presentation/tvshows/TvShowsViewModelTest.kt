package com.example.moviedatabase.presentation.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviedatabase.data.repos.FakeTvShowRepo
import com.example.moviedatabase.domain.usecases.GetTvShowsUseCase
import com.example.moviedatabase.domain.usecases.UpdateTvShowsUseCase
import com.example.moviedatabase.getOrAwaitValueTest
import com.google.common.truth.Truth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TvShowsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TvShowsViewModel
    private lateinit var repo: FakeTvShowRepo

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        repo = FakeTvShowRepo()
        viewModel = TvShowsViewModel(GetTvShowsUseCase(repo), UpdateTvShowsUseCase(repo))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getTvShowsReturnsCorrectList() = runTest {
        val content = repo.updateTvShows()
        val result = viewModel.getTvShows().getOrAwaitValueTest()
        Truth.assertThat(result).containsExactlyElementsIn(content)
    }

    @Test
    fun updateTvShowsReturnsCorrectList() = runTest {
        val result = viewModel.updateTvShows().getOrAwaitValueTest()
        val content = repo.getTvShows()
        Truth.assertThat(content).containsExactlyElementsIn(result)
    }
}