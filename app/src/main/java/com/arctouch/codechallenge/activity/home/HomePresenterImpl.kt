package com.arctouch.codechallenge.activity.home

import android.os.Bundle
import com.arctouch.codechallenge.activity.base.BasePresenterImpl
import com.arctouch.codechallenge.infra.api.TmdbApi
import com.arctouch.codechallenge.infra.data.Cache
import com.arctouch.codechallenge.model.UpcomingMoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.lang.Exception

class HomePresenterImpl(var view: HomeView, var serviceApi: TmdbApi) : BasePresenterImpl(view),
                                                   HomePresenter,
                                                   Subscriber<UpcomingMoviesResponse>{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        serviceApi.upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, 1, TmdbApi.DEFAULT_REGION)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { onComplete() }
                .doOnNext { onNext(it) }
                .doOnError { onError(it) }
                .subscribe()
    }

    override fun onComplete() {
        view.onStopSearch()
    }

    override fun onSubscribe(s: Subscription?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNext(response: UpcomingMoviesResponse) {
        val moviesWithGenres = response.results.map { movie ->
            movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
        }
        view.addMovies(moviesWithGenres)
    }

    override fun onError(t: Throwable?) {
        view.onError(exception = Exception(""))
    }

}