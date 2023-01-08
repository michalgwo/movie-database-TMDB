package com.example.moviedatabase.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.moviedatabase.data.model.movie.Movie
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
class MovieDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: MoviesDb
    private lateinit var dao: MovieDao

    @Before
    fun setUp() {
        hiltRule.inject()
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