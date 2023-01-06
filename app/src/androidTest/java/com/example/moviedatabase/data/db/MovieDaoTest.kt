package com.example.moviedatabase.data.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.moviedatabase.data.model.movie.Movie
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
class MovieDaoTest {
    private lateinit var database: MoviesDb
    private lateinit var dao: MovieDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MoviesDb::class.java
        ).allowMainThreadQueries().build()
        dao = database.movieDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun saveMovies() = runTest {
        val list = listOf(
            Movie(false, "a", 1, "en", "Name1", "d2sad", 31.7655, "qwerty", "a", "v", false, 3.1, 5),
            Movie(true, "b", 2, "pl", "Name3", "dsafdfd", 1.6, "asdf", "d", "vggg", false, 33.1, 503),
            Movie(false, "f", 3, "es", "Name14", "fdsedsad", 31.0, "zxcv", "g", "g", true, 49.1, 8640)
        )
        dao.saveMovies(list)
        assertThat(dao.getMovies()).containsAtLeastElementsIn(list)
    }

    @Test
    fun deleteAllMovies() = runTest {
        val list = listOf(
            Movie(false, "a", 1, "en", "Name1", "d2sad", 31.7655, "qwerty", "a", "v", false, 3.1, 5),
            Movie(true, "b", 2, "pl", "Name3", "dsafdfd", 1.6, "asdf", "d", "vggg", false, 33.1, 503),
            Movie(false, "f", 3, "es", "Name14", "fdsedsad", 31.0, "zxcv", "g", "g", true, 49.1, 8640)
        )
        dao.saveMovies(list)
        dao.deleteAllMovies()
        assertThat(dao.getMovies()).isEmpty()
    }
}