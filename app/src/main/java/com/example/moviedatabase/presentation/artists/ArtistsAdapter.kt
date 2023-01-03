package com.example.moviedatabase.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.R
import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.databinding.ListItemBinding

class ArtistsAdapter: RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {
    private var artists = ArrayList<Artist>()

    fun updateList(newList: List<Artist>) {
        artists.clear()
        artists.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artists[position])
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist) {
            binding.tvTitle.text = artist.name
            binding.tvDescription.text = binding.ivListItem.context.getString(R.string.known_for, artist.knownForDepartment)

            val profileURL = "https://image.tmdb.org/t/p/w500${artist.profilePath}"
            Glide.with(binding.ivListItem.context).load(profileURL).into(binding.ivListItem)
        }
    }
}