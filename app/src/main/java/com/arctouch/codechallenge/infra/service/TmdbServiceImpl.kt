package com.arctouch.codechallenge.infra.service

import com.arctouch.codechallenge.BuildConfig.API_KEY
import com.arctouch.codechallenge.BuildConfig.BASE_URL
import com.arctouch.codechallenge.infra.HttpResponseHandler
import com.arctouch.codechallenge.infra.api.TmdbApi
import com.arctouch.codechallenge.model.UpcomingMoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TmdbServiceImpl(var serviceApi: TmdbApi) : TmdbService {

    override fun getBaseUrl(): String {
        return BASE_URL
    }

    override fun getKeyApi(): String {
        return API_KEY
    }

    override fun getUpcomingMovies(httpHandler: HttpResponseHandler<UpcomingMoviesResponse>,
                                   language: String,
                                   region: String,
                                   pagePosition: Long) {

        serviceApi.upcomingMovies(this.getKeyApi(), language, pagePosition, region)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { httpHandler.onComplete() }
                .doOnNext { httpHandler.onReceive(it) }
                .doOnError { httpHandler.onError(it) }
                .subscribe()
    }

}