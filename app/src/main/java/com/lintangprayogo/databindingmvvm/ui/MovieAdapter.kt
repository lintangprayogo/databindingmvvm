package com.lintangprayogo.databindingmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lintangprayogo.databindingmvvm.R
import com.lintangprayogo.databindingmvvm.data.model.Movie
import com.lintangprayogo.databindingmvvm.databinding.MovieItemBinding

class MovieAdapter(private val movies: List<Movie>,private  val listener:MovieClickInterface) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.movieItemBinding.movie = movies.get(position)

        holder.movieItemBinding.buttonBook.setOnClickListener {
          listener.onItemClicked(it,movies[holder.adapterPosition])
        }

        holder.movieItemBinding.layoutLike.setOnClickListener {
            listener.onItemClicked(it,movies[holder.adapterPosition])
        }
    }

    inner class MovieHolder(val movieItemBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(movieItemBinding.root)
}