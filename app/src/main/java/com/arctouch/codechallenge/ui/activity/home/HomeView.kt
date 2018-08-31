package com.arctouch.codechallenge.ui.activity.home

import com.arctouch.codechallenge.ui.activity.base.BaseView
import com.arctouch.codechallenge.ui.activity.base.LoaderView
import com.jgabrielfreitas.models.Movie
import java.lang.Exception

interface HomeView : BaseView, LoaderView {

  fun addMovies(movies: List<Movie>)

  fun onError(exception: Exception)

  fun openMovieDetails(movie: Movie)

}