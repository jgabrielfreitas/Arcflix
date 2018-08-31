package com.arctouch.codechallenge.activity.details

import com.arctouch.codechallenge.activity.base.BaseView
import com.arctouch.codechallenge.activity.base.LoaderView
import com.jgabrielfreitas.models.Movie
import java.lang.Exception

interface DetailsView : BaseView, LoaderView {

    fun showMovieData(movie: Movie)

    fun onError(exception: Exception)

}