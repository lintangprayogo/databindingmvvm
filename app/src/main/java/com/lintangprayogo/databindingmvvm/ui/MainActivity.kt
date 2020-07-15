package com.lintangprayogo.databindingmvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lintangprayogo.databindingmvvm.R
import com.lintangprayogo.databindingmvvm.data.network.MovieApi
import com.lintangprayogo.databindingmvvm.data.repo.MovieRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo =
            MovieRepo(MovieApi())
        GlobalScope.launch(Dispatchers.Main) {
            val movies = repo.getMovies()
            Log.d(TAG, "movies: " + movies.toString())
        }
    }
}