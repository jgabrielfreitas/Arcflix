package com.arctouch.codechallenge.activity.details

import android.os.Bundle
import com.arctouch.codechallenge.activity.base.BasePresenterImpl
import com.arctouch.codechallenge.infra.HttpResponseHandler
import com.arctouch.codechallenge.infra.service.tmdb.TmdbService
import com.arctouch.codechallenge.model.Movie
import java.lang.Exception

class DetailsPresenterImpl(var view: DetailsView, var serviceApi: TmdbService) : BasePresenterImpl(view),
                                                                                 DetailsPresenter,
                                                                                 HttpResponseHandler<Movie> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = savedInstanceState?.getParcelable<Movie>("movie")
        movie?.id?.let { movieId ->
            view.onStartSearch()
            serviceApi.getRemoteMovieDetails(this, movieId)
        }
    }


    override fun onReceive(response: Movie) {
        view.showMovieData(response)
    }

    override fun onComplete() {
        view.onStopSearch()
    }

    override fun onError(throwable: Throwable) {
        view.onError(Exception("a exception occurs"))
    }
}