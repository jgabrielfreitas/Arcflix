package com.arctouch.codechallenge.ui.activity.home

import com.arctouch.codechallenge.ui.activity.base.BasePresenterContract
import com.jgabrielfreitas.models.Movie

interface HomePresenter: BasePresenterContract {

    fun onMovieClicked(movie: Movie)

    fun requestUpcomingMovies(page: Long)

}