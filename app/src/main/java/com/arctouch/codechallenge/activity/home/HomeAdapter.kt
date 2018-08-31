package com.arctouch.codechallenge.activity.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.helper.MovieHelper
import com.arctouch.codechallenge.util.MovieImageUrlBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jgabrielfreitas.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.genresTextView
import kotlinx.android.synthetic.main.movie_item.view.posterImageView
import kotlinx.android.synthetic.main.movie_item.view.releaseDateTextView
import kotlinx.android.synthetic.main.movie_item.view.titleTextView

class HomeAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    lateinit var onItemClick: ((Movie) -> Unit)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val movieImageUrlBuilder = MovieImageUrlBuilder()


        fun bind(movie: Movie) {
            itemView.titleTextView.text = movie.title
            itemView.genresTextView.text = movie.genres()
            itemView.releaseDateTextView.text = MovieHelper().releaseDate(movie)

            Glide.with(itemView)
                 .load(movie.posterPath?.let { movieImageUrlBuilder.buildPosterUrl(it) })
                 .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
                 .into(itemView.posterImageView)

            itemView.setOnClickListener { onItemClick.invoke(movie) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])
}
