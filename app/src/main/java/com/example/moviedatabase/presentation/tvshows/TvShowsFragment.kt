package com.example.moviedatabase.presentation.tvshows

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabase.R
import com.example.moviedatabase.data.model.tvshow.TvShow
import com.example.moviedatabase.databinding.FragmentTvShowsBinding
import com.example.moviedatabase.presentation.App
import javax.inject.Inject

class TvShowsFragment : Fragment() {
    private lateinit var binding: FragmentTvShowsBinding
    private lateinit var adapter: TvShowsAdapter
    @Inject
    lateinit var factory: TvShowsViewModelFactory
    @Inject
    lateinit var viewModel: TvShowsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireContext().applicationContext as App)
            .createTvShowSubcomponent(requireActivity())
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv_shows, container, false)
        initRecyclerView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createMenu()
    }

    private fun initRecyclerView() {
        binding.rvTvShows.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        adapter = TvShowsAdapter()
        binding.rvTvShows.adapter = adapter
        displayTvShowList()
    }

    private fun displayTvShowList() {
        binding.pbTvShows.visibility = View.VISIBLE

        viewModel.getTvShows().observe(viewLifecycleOwner) {
            updateRecyclerView(it)
        }
    }

    private fun updateTvShows() {
        binding.pbTvShows.visibility = View.VISIBLE

        viewModel.updateTvShows().observe(viewLifecycleOwner) {
            updateRecyclerView(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateRecyclerView(list: List<TvShow>?) {
        if (list != null) {
            adapter.updateList(list)
            adapter.notifyDataSetChanged()
        }
        binding.pbTvShows.visibility = View.GONE
    }

    private fun createMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.bUpdate -> {
                        updateTvShows()
                        return true
                    }
                }

                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}