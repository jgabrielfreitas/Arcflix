package com.arctouch.codechallenge.ui.activity.home

import com.arctouch.codechallenge.ui.activity.base.BaseView
import com.arctouch.codechallenge.ui.activity.base.HttpRequesterHandlerView
import com.arctouch.codechallenge.ui.activity.base.LoaderView
import com.jgabrielfreitas.models.Movie

interface HomeView : BaseView, HttpRequesterHandlerView, LoaderView {

  fun addMovies(movies: List<Movie>)

  fun openMovieDetails(movie: Movie)

}