package com.example.moviedatabase.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviedatabase.data.repos.FakeArtistRepo
import com.example.moviedatabase.domain.repointerfaces.ArtistRepo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetArtistsUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repo: ArtistRepo
    private lateinit var getArtistsUseCase: GetArtistsUseCase

    @Before
    fun setUp() {
        repo = FakeArtistRepo()
        getArtistsUseCase = GetArtistsUseCase(repo)
    }

    @Test
    fun getArtistsReturnsCorrectList() = runTest {
        val content = repo.updateArtists()
        val result = getArtistsUseCase.execute()
        assertThat(result).containsExactlyElementsIn(content)
    }
}