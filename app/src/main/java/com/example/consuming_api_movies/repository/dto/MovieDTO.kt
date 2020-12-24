package com.example.consuming_api_movies

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName(value = "name")
    val name: String,
    @SerializedName(value = "director")
    val director: String,
    @SerializedName(value = "year")
    val year: Int,
    @SerializedName(value = "like")
    val like: Boolean
)



