package com.example.moviedatabase.presentation.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviedatabase.data.repos.FakeMovieRepo
import com.example.moviedatabase.domain.usecases.GetMoviesUseCase
import com.example.moviedatabase.domain.usecases.UpdateMoviesUseCase
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
class MoviesViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MoviesViewModel
    private lateinit var repo: FakeMovieRepo

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        repo = FakeMovieRepo()
        viewModel = MoviesViewModel(GetMoviesUseCase(repo), UpdateMoviesUseCase(repo))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getMoviesReturnsCorrectList() = runTest {
        val content = repo.updateMovies()
        val result = viewModel.getMovies().getOrAwaitValueTest()
        Truth.assertThat(result).containsExactlyElementsIn(content)
    }

    @Test
    fun updateMoviesReturnsCorrectList() = runTest {
        val result = viewModel.updateMovies().getOrAwaitValueTest()
        val content = repo.getMovies()
        Truth.assertThat(content).containsExactlyElementsIn(result)
    }
}