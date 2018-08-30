package com.arctouch.codechallenge.activity.home

import android.os.Bundle
import com.arctouch.codechallenge.activity.base.BasePresenterImpl
import com.arctouch.codechallenge.infra.api.TmdbApi
import com.arctouch.codechallenge.infra.data.Cache
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class HomePresenterImpl(var view: HomeView,
                        var serviceApi: TmdbApi) : BasePresenterImpl(view), HomePresenter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        serviceApi.upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, 1, TmdbApi.DEFAULT_REGION)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    view.onError(exception = Exception(""))
                }
                .doOnNext {
                    val moviesWithGenres = it.results.map { movie ->
                        movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
                    }
                    view.addMovies(moviesWithGenres)
                }
                .doOnComplete { view.onStopSearch() }
                .subscribe()
    }

}