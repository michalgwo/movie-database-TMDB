package com.example.moviedatabase.data.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.moviedatabase.data.model.artist.Artist
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
@SmallTest
class ArtistDaoTest {
    private lateinit var database: MoviesDb
    private lateinit var dao: ArtistDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MoviesDb::class.java
        ).allowMainThreadQueries().build()
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