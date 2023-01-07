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
class GetMoviesUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repo: MovieRepo
    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Before
    fun setUp() {
        repo = FakeMovieRepo()
        getMoviesUseCase = GetMoviesUseCase(repo)
    }

    @Test
    fun getMoviesReturnsCorrectList() = runTest {
        val content = repo.updateMovies()
        val result = getMoviesUseCase.execute()
        Truth.assertThat(result).containsExactlyElementsIn(content)
    }
}