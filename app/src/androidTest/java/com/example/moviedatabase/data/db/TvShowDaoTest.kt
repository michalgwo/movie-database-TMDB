package com.example.moviedatabase.data.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.moviedatabase.data.model.tvshow.TvShow
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
class TvShowDaoTest {
    private lateinit var database: MoviesDb
    private lateinit var dao: TvShowDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MoviesDb::class.java
        ).allowMainThreadQueries().build()
        dao = database.tvShowDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun saveTvShows() = runTest {
        val list = listOf(
            TvShow("false", "fdsd", 1, "RANDOM1", "en", "random1", "oasdas", 31.7, "qwrty", 2.12, 935453412),
            TvShow("dsa", "efsf0", 2, "RANDOM2", "ar", "322", "oasda51s", 35.76, "qo8wety", 0.12, 7345312),
            TvShow("444f", "0231", 3, "RANDOM3", "rr", "555", "13oasdas", 9931.6, "wery", 5.12, 4334412)
        )
        dao.saveTvShows(list)
        assertThat(dao.getTvShows()).containsAtLeastElementsIn(list)
    }

    @Test
    fun deleteAllTvShows() = runTest {
        val list = listOf(
            TvShow("false", "fdsd", 1, "RANDOM1", "en", "random1", "oasdas", 31.7, "qwrty", 2.12, 935453412),
            TvShow("dsa", "efsf0", 2, "RANDOM2", "ar", "322", "oasda51s", 35.76, "qo8wety", 0.12, 7345312),
            TvShow("444f", "0231", 3, "RANDOM3", "rr", "555", "13oasdas", 9931.6, "wery", 5.12, 4334412)
        )
        dao.saveTvShows(list)
        dao.deleteAllTvShows()
        assertThat(dao.getTvShows()).isEmpty()
    }
}