package com.lintangprayogo.databindingmvvm.data.repo

import com.lintangprayogo.databindingmvvm.data.network.MovieApi

class MovieRepo(private val api: MovieApi) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest {
        api.getMovies()
    }
}