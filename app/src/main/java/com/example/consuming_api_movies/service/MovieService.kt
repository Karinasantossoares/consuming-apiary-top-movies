package com.example.consuming_api_movies.service

import com.example.consuming_api_movies.MovieDTO
import io.reactivex.Single
import retrofit2.http.GET

interface MovieService {
    @GET("movies")
    fun listMovie() : Single<List<MovieDTO>>
}