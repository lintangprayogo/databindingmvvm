package com.lintangprayogo.databindingmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lintangprayogo.databindingmvvm.R
import com.lintangprayogo.databindingmvvm.data.model.Movie
import com.lintangprayogo.databindingmvvm.data.network.MovieApi
import com.lintangprayogo.databindingmvvm.data.repo.MovieRepo
import kotlinx.android.synthetic.main.movie_fragment.*

class MovieFragment : Fragment(),MovieClickInterface  {


    private lateinit var viewModel: MovieViewModel
    private lateinit var factory: ViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MovieApi()
        val repo = MovieRepo(api)
        factory = ViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this, factory).get(MovieViewModel::class.java)
        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies->
            rv_movies.also {
                it.layoutManager=LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MovieAdapter(movies,this)
            }
        })

    }

    override fun onItemClicked(view: View, movie: Movie) {
        when(view.id){
            R.id.button_book->{
                Toast.makeText(requireContext(),"${movie.title} has been book",Toast.LENGTH_SHORT).show()
            }
            R.id.layout_like->{
                Toast.makeText(requireContext(),"${movie.title} has been like",Toast.LENGTH_SHORT).show()
            }
        }
    }
}