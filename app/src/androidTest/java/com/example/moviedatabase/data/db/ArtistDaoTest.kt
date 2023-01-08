package com.example.moviedatabase.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.moviedatabase.data.model.artist.Artist
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@OptIn(ExperimentalCoroutinesApi::class)
@SmallTest
@HiltAndroidTest
class ArtistDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: MoviesDb
    private lateinit var dao: ArtistDao

    @Before
    fun setUp() {
        hiltRule.inject()
        dao = database.artistDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun saveArtists() = runTest {
        val list = listOf(
            Artist(false, 0, 1, "RANDOM1", "Name1", 31.76, "qwerty"),
            Artist(true, 1, 2, "RANDOM2", "Name2", 551.1, "asdfg"),
            Artist(false, 1, 3, "RANDOM3", "Name3", 123.2, "zxcvb")
        )
        dao.saveArtists(list)
        assertThat(dao.getArtists()).containsAtLeastElementsIn(list)
    }

    @Test
    fun deleteAllArtists() = runTest {
        val list = listOf(
            Artist(false, 0, 1, "RANDOM1", "Name1", 31.76, "qwerty"),
            Artist(true, 1, 2, "RANDOM2", "Name2", 551.1, "asdfg"),
            Artist(false, 1, 3, "RANDOM3", "Name3", 123.2, "zxcvb")
        )
        dao.saveArtists(list)
        dao.deleteAllArtists()
        assertThat(dao.getArtists()).isEmpty()
    }
}