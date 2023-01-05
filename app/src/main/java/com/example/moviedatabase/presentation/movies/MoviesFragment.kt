package com.example.moviedatabase.presentation.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabase.R
import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapter: MoviesAdapter
    private val viewModel: MoviesViewModel by hiltNavGraphViewModels(R.id.mobile_navigation)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)

        initRecyclerView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createMenu()
    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        adapter = MoviesAdapter()
        binding.rvMovies.adapter = adapter
        displayMovieList()
    }

    private fun displayMovieList() {
        binding.pbMovies.visibility = View.VISIBLE

        viewModel.getMovies().observe(viewLifecycleOwner) {
            updateRecyclerView(it)
        }
    }

    private fun updateMovies() {
        binding.pbMovies.visibility = View.VISIBLE

        viewModel.updateMovies().observe(viewLifecycleOwner) {
            updateRecyclerView(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateRecyclerView(list: List<Movie>?) {
        if (list != null) {
            adapter.updateList(list)
            adapter.notifyDataSetChanged()
        }
        binding.pbMovies.visibility = View.GONE
    }

    private fun createMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.bUpdate -> {
                        updateMovies()
                        return true
                    }
                }

                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}