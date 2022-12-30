package com.example.moviedatabase.presentation.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviedatabase.R
import com.example.moviedatabase.databinding.FragmentArtistsBinding

class ArtistsFragment : Fragment() {
    private lateinit var binding: FragmentArtistsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artists, container, false)

        return binding.root
    }
}