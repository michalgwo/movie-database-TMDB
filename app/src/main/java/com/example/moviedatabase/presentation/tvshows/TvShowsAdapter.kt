package com.example.moviedatabase.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.R
import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.databinding.ListItemBinding

class TvShowsAdapter: RecyclerView.Adapter<TvShowsAdapter.ViewHolder>() {
    private var tvShows = ArrayList<TvShow>()

    fun updateList(newList: List<TvShow>) {
        tvShows.clear()
        tvShows.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            binding.tvTitle.text = tvShow.name
            binding.tvDescription.text = tvShow.overview

            val posterURL = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}"
            Glide.with(binding.ivListItem.context).load(posterURL).into(binding.ivListItem)
        }
    }
}