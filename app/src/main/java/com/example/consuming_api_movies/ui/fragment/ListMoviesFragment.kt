package com.example.consuming_api_movies.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.consuming_api_movies.R
import com.example.consuming_api_movies.data.Movie
import com.example.consuming_api_movies.databinding.FragmentListMoviesBinding
import com.example.consuming_api_movies.ui.adapter.MoviesAdapter
import com.example.consuming_api_movies.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_list_movies.*


class ListMoviesFragment : Fragment() {

    private lateinit var binding: FragmentListMoviesBinding

    private val viewModel by lazy {
        ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_movies, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tb_my_toolbar.setTitle("Filmes")


        viewModel.getMovie()

        viewModel.loadLiveData.observe(this.viewLifecycleOwner, Observer {
            binding.pbLoad.isVisible = it
        })
        viewModel.sucessLiveData.observe(this.viewLifecycleOwner, Observer { listMovie ->
            val adapter = MoviesAdapter(listMovie) {
                val bundle = bundleOf(
                    FavoriteMovieFragment.MOVIE to it
                )
                view.findNavController()
                    .navigate(R.id.action_listMoviesFragment_to_favoriteMovieFragment, bundle)
            }
            rv_recycler_movies.adapter = adapter
        })

        viewModel.toastLiveData.observe(this.viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })
    }


}
