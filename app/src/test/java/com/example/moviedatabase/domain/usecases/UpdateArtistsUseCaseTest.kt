package com.example.moviedatabase.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviedatabase.data.repos.FakeArtistRepo
import com.example.moviedatabase.domain.repointerfaces.ArtistRepo
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UpdateArtistsUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repo: ArtistRepo
    private lateinit var updateArtistsUseCase: UpdateArtistsUseCase

    @Before
    fun setUp() {
        repo = FakeArtistRepo()
        updateArtistsUseCase = UpdateArtistsUseCase(repo)
    }

    @Test
    fun updateArtistsReturnsCorrectList() = runTest {
        val result = updateArtistsUseCase.execute()
        val content = repo.getArtists()
        Truth.assertThat(content).containsExactlyElementsIn(result)
    }
}