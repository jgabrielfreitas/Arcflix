package com.arctouch.codechallenge.activity.home

import android.os.Bundle
import com.arctouch.codechallenge.activity.base.BasePresenterImpl
import com.arctouch.codechallenge.infra.HttpResponseHandler
import com.arctouch.codechallenge.infra.data.Cache
import com.arctouch.codechallenge.infra.service.tmdb.TmdbService
import com.arctouch.codechallenge.model.Movie
import com.arctouch.codechallenge.model.UpcomingMoviesResponse
import java.lang.Exception

class HomePresenterImpl(var view: HomeView, var serviceApi: TmdbService) : BasePresenterImpl(view),
                                                   HomePresenter, HttpResponseHandler<UpcomingMoviesResponse> {

    private val firstPage: Long = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestUpcomingMovies(firstPage)
    }

    override fun requestUpcomingMovies(page: Long) {
        view.onStartSearch()
        serviceApi.getUpcomingMovies(httpHandler = this, pagePosition = page)
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
        view.onError(Exception("a exception occurs"))
    }

    override fun onMovieClicked(movie: Movie) {
        view.openMovieDetails(movie)
    }

}