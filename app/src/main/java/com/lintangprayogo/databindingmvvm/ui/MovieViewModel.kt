package com.lintangprayogo.databindingmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lintangprayogo.databindingmvvm.data.model.Movie
import com.lintangprayogo.databindingmvvm.data.repo.MovieRepo
import com.lintangprayogo.util.Coroutines
import kotlinx.coroutines.Job

class MovieViewModel(private val repo: MovieRepo) : ViewModel() {

    private lateinit var job: Job
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {
        job = Coroutines.ioThenMain(
            {
                repo.getMovies()
            },
            {
                _movies.value = it
            }
        )

    }

    override fun onCleared() {
        if (::job.isInitialized) {
            job.cancel()
        }
    }
}