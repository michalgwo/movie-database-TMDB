package com.example.moviedatabase.presentation.movies

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabase.R
import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.databinding.FragmentMoviesBinding
import com.example.moviedatabase.presentation.App
import com.example.moviedatabase.presentation.di.core.ViewModelModule
import javax.inject.Inject

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapter: MoviesAdapter
    @Inject
    lateinit var factory: MoviesViewModelFactory
    @Inject
    lateinit var viewModel: MoviesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireContext().applicationContext as App).createMovieSubcomponent(ViewModelModule(this)).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)

        createMenu()
        initRecyclerView()

        return binding.root
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
        }, viewLifecycleOwner)
    }
}