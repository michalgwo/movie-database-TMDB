package com.example.moviedatabase.presentation.artists

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviedatabase.data.repos.FakeArtistRepo
import com.example.moviedatabase.domain.usecases.GetArtistsUseCase
import com.example.moviedatabase.domain.usecases.UpdateArtistsUseCase
import com.example.moviedatabase.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ArtistsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ArtistsViewModel
    private lateinit var repo: FakeArtistRepo

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        repo = FakeArtistRepo()
        viewModel = ArtistsViewModel(GetArtistsUseCase(repo), UpdateArtistsUseCase(repo))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getArtistsReturnsCorrectList() = runTest {
        val content = repo.updateArtists()
        val result = viewModel.getArtists().getOrAwaitValueTest()
        assertThat(result).containsExactlyElementsIn(content)
    }

    @Test
    fun updateArtistsReturnsCorrectList() = runTest {
        val result = viewModel.updateArtists().getOrAwaitValueTest()
        val content = repo.getArtists()
        assertThat(content).containsExactlyElementsIn(result)
    }
}