package com.example.consuming_api_movies.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.consuming_api_movies.data.Movie
import com.example.consuming_api_movies.R


class MoviesAdapter(private val movie: List<Movie>, val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_movies, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount() = movie.count()

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
            holder.bindView(movie[position])

    }

     inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameMovie = itemView.findViewById<TextView>(R.id.tv_name_movie)
        private val nameDirecor = itemView.findViewById<TextView>(R.id.tv_name_director)
        private val yearMovie = itemView.findViewById<TextView>(R.id.tv_year_movie)
        private val favoriteMovie = itemView.findViewById<TextView>(R.id.tv_favorite)

        fun bindView(movie : Movie){
            nameMovie.text = movie.name
            nameDirecor.text = movie.director
            yearMovie.text= movie.year.toString()
            favoriteMovie.setOnClickListener {
                onClick.invoke(movie)
            }

        }



    }
}