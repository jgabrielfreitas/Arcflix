package com.arctouch.codechallenge.ui.activity.details

import android.os.Bundle
import com.arctouch.codechallenge.ui.activity.base.BasePresenterImpl
import com.jgabrielfreitas.infrastructure.HttpResponseHandler
import com.jgabrielfreitas.models.Movie
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import java.lang.Exception

class DetailsPresenterImpl(var view: DetailsView, var serviceApi: TmdbService) : BasePresenterImpl(view),
                                                                                 DetailsPresenter,
                                                                                 HttpResponseHandler<Movie> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieId = savedInstanceState?.getLong("movieId")
        movieId?.let {
            view.onStartSearch()
            serviceApi.getRemoteMovieDetails(this, it)
        }
    }


    override fun onReceive(response: Movie) {
        view.showMovieData(response)
    }

    override fun onComplete() {
        view.onStopSearch()
    }

    override fun onError(throwable: Throwable?) {
        view.onError(Exception("a exception occurs"))
    }
}