package com.example.moviedatabase.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviedatabase.data.repos.FakeMovieRepo
import com.example.moviedatabase.domain.repointerfaces.MovieRepo
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UpdateMoviesUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repo: MovieRepo
    private lateinit var updateMoviesUseCase: UpdateMoviesUseCase

    @Before
    fun setUp() {
        repo = FakeMovieRepo()
        updateMoviesUseCase = UpdateMoviesUseCase(repo)
    }

    @Test
    fun updateMoviesReturnsCorrectList() = runTest {
        val result = updateMoviesUseCase.execute()
        val content = repo.getMovies()
        Truth.assertThat(content).containsExactlyElementsIn(result)
    }
}