package com.example.consuming_api_movies.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val name :String,
    val director :String,
    val year : Int,
    val like :Boolean
) :Parcelable
