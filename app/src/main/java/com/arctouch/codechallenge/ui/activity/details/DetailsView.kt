package com.arctouch.codechallenge.ui.activity.details

import com.arctouch.codechallenge.ui.activity.base.BaseView
import com.arctouch.codechallenge.ui.activity.base.LoaderView
import com.jgabrielfreitas.models.Movie
import java.lang.Exception

interface DetailsView : BaseView, LoaderView {

    fun showMovieData(movie: Movie)

    fun onError(exception: Exception)

}