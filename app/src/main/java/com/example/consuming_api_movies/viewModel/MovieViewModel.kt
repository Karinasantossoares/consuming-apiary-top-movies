package com.example.consuming_api_movies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.consuming_api_movies.data.Movie
import com.example.consuming_api_movies.repository.MovieRepository
import io.reactivex.disposables.Disposable

class MovieViewModel : ViewModel() {
    var disposableListMovie: Disposable? = null
    val repository by lazy { MovieRepository() }
    val loadLiveData = MutableLiveData<Boolean>()
    val sucessLiveData = MutableLiveData<List<Movie>>()
    val toastLiveData = MutableLiveData<String>()


    fun getMovie() {
        loadLiveData.value = true
        repository.listMovie()
            .doOnSubscribe {
                disposableListMovie = it
            }
            .doOnSuccess {
                sucessLiveData.value = it
            }
            .doOnError {
                toastLiveData.value = it.message
            }
            .doFinally {
                loadLiveData.value = false
            }.subscribe()
    }

    override fun onCleared() {
        super.onCleared()
        disposableListMovie?.dispose()
    }

}