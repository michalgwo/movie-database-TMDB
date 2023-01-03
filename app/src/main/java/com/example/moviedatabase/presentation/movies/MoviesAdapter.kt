package com.example.moviedatabase.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.R
import com.example.moviedatabase.data.model.movie.Movie
import com.example.moviedatabase.databinding.ListItemBinding

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var movies = ArrayList<Movie>()

    fun updateList(newList: List<Movie>) {
        movies.clear()
        movies.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.title
            binding.tvDescription.text = movie.overview

            val posterURL = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
            Glide.with(binding.ivListItem.context).load(posterURL).into(binding.ivListItem)
        }
    }
}