package com.example.consuming_api_movies.repository

import com.example.consuming_api_movies.MovieDTO
import com.example.consuming_api_movies.data.Movie
import com.example.consuming_api_movies.repository.retrofit.RetrofitConfig
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//FUNÇÃO DE GERENCIAR AS THREADS E CONVERTER OS OBJETOS ENTRE DTO E
class MovieRepository {
    private val retrofit by lazy { RetrofitConfig() }
    private val service by lazy { retrofit.movieService }

    fun listMovie() = service.listMovie().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).map{
            it.map {
                Movie(it.name, it.director, it.year, it.like)
            }
        }

//    fun listMovie(): Single<List<Movie>> {
//        //PEGAR CONTÉUDO COM AGENDAMENTO DE THREADS
//        val singleDTO: Single<List<MovieDTO>> =
//            service.listMovie().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//
//        //TIRAR DA CAIXA SINGLE E CONVERTER PARA OBJETO DA VIEW
//       return singleDTO.map{ conteudoDoPacote->
//            conteudoDoPacote.map {
//                Movie(it.name, it.director, it.year, it.like)
//            }
//        }
//    }
}