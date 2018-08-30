package com.arctouch.codechallenge.activity.home

import android.os.Bundle
import com.arctouch.codechallenge.activity.base.BasePresenterImpl
import com.arctouch.codechallenge.infra.HttpResponseHandler
import com.arctouch.codechallenge.infra.service.TmdbService
import com.arctouch.codechallenge.infra.api.TmdbApi
import com.arctouch.codechallenge.infra.data.Cache
import com.arctouch.codechallenge.model.UpcomingMoviesResponse
import java.lang.Exception

class HomePresenterImpl(var view: HomeView, var serviceApi: TmdbService) : BasePresenterImpl(view),
                                                   HomePresenter, HttpResponseHandler<UpcomingMoviesResponse> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestUpcomingMovies()
    }

    private fun requestUpcomingMovies(page: Long=1) {
        serviceApi.getUpcomingMovies(httpHandler = this,
                language = TmdbApi.DEFAULT_LANGUAGE,
                region = TmdbApi.DEFAULT_REGION,
                pagePosition = page)
    }

    override fun onComplete() {
        view.onStopSearch()
    }

    override fun onReceive(response: UpcomingMoviesResponse) {
        val moviesWithGenres = response.results.map { movie ->
            movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
        }
        view.addMovies(moviesWithGenres)
    }

    override fun onError(throwable: Throwable) {
        view.onError(exception = Exception(""))
    }

}