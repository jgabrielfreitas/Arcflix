package com.arctouch.codechallenge.activity.home

import com.arctouch.codechallenge.activity.base.BasePresenterContract
import com.arctouch.codechallenge.model.Movie

interface HomePresenter: BasePresenterContract {

    fun onMovieClicked(movie: Movie)

    fun requestUpcomingMovies(page: Long)

}