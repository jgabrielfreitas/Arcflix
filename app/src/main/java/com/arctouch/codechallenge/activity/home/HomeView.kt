package com.arctouch.codechallenge.activity.home

import com.arctouch.codechallenge.activity.base.BaseView
import com.arctouch.codechallenge.model.Movie
import java.lang.Exception

interface HomeView : BaseView {

  fun onStartSearch()

  fun onStopSearch()

  fun addMovies(movies: List<Movie>)

  fun onError(exception: Exception)

  fun openMovieDetails(movie: Movie)

}