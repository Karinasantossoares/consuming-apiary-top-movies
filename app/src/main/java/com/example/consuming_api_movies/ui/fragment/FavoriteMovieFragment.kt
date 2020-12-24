package com.example.consuming_api_movies.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.consuming_api_movies.R
import com.example.consuming_api_movies.data.Movie
import com.example.consuming_api_movies.databinding.FragmentFavoriteMovieBinding

class FavoriteMovieFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_favorite_movie, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = arguments?.getParcelable<Movie>(MOVIE)
        binding.tvDetaislNameMovie.text = movie?.name
        binding.tvDetaislDirectorMovie.text = movie?.director
        binding.tvDetaislYearMovie.text = movie?.year.toString()
    }

    companion object {
        const val MOVIE = "MOVIE"
    }
}