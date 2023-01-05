package com.example.moviedatabase.presentation.artists

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
import com.example.moviedatabase.data.model.artist.Artist
import com.example.moviedatabase.databinding.FragmentArtistsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistsFragment : Fragment() {
    private lateinit var binding: FragmentArtistsBinding
    private lateinit var adapter: ArtistsAdapter
    private val viewModel: ArtistsViewModel by hiltNavGraphViewModels(R.id.mobile_navigation)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artists, container, false)
        initRecyclerView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createMenu()
    }

    private fun initRecyclerView() {
        binding.rvArtists.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        adapter = ArtistsAdapter()
        binding.rvArtists.adapter = adapter
        displayArtistList()
    }

    private fun displayArtistList() {
        binding.pbArtists.visibility = View.VISIBLE

        viewModel.getArtists().observe(viewLifecycleOwner) {
            updateRecyclerView(it)
        }
    }

    private fun updateArtists() {
        binding.pbArtists.visibility = View.VISIBLE

        viewModel.updateArtists().observe(viewLifecycleOwner) {
            updateRecyclerView(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateRecyclerView(list: List<Artist>?) {
        if (list != null) {
            adapter.updateList(list)
            adapter.notifyDataSetChanged()
        }
        binding.pbArtists.visibility = View.GONE
    }

    private fun createMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.bUpdate -> {
                        updateArtists()
                        return true
                    }
                }

                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}