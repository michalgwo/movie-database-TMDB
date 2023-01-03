package com.example.moviedatabase.presentation.movies

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabase.R
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

        val moviesLiveData = viewModel.getMovies()
        moviesLiveData.observe(viewLifecycleOwner) {
            Log.d("MyTag", it.toString())
        }

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        adapter = MoviesAdapter()
        binding.rvMovies.adapter = adapter
        displayMovieList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayMovieList() {
        val moviesLiveData = viewModel.getMovies()
        moviesLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.updateList(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}