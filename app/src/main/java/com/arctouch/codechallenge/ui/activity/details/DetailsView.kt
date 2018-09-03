package com.arctouch.codechallenge.ui.activity.details

import com.arctouch.codechallenge.ui.activity.base.BaseView
import com.arctouch.codechallenge.ui.activity.base.HttpRequesterHandlerView
import com.arctouch.codechallenge.ui.activity.base.LoaderView
import com.jgabrielfreitas.models.Movie

interface DetailsView : BaseView, HttpRequesterHandlerView, LoaderView {

    fun showMovieData(movie: Movie)

}