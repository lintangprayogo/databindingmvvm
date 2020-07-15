package com.lintangprayogo.databindingmvvm.data.network

import com.lintangprayogo.databindingmvvm.data.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {
    @GET("movies")
    suspend fun getMovies(): Response<List<Movie>>

    companion object {
        operator fun invoke(): MovieApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build().create(MovieApi::class.java)
        }
    }
}