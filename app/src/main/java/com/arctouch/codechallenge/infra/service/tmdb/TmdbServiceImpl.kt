package com.arctouch.codechallenge.infra.service.tmdb

import com.arctouch.codechallenge.BuildConfig.API_KEY
import com.arctouch.codechallenge.BuildConfig.BASE_URL
import com.arctouch.codechallenge.infra.HttpResponseHandler
import com.arctouch.codechallenge.infra.api.TmdbApi
import com.arctouch.codechallenge.infra.service.LocationConfigurationService
import com.arctouch.codechallenge.model.UpcomingMoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TmdbServiceImpl(var serviceApi: TmdbApi,
                      var locationConfig: LocationConfigurationService) : TmdbService {

    override fun getBaseUrl(): String {
        return BASE_URL
    }

    override fun getKeyApi(): String {
        return API_KEY
    }

    override fun getUpcomingMovies(httpHandler: HttpResponseHandler<UpcomingMoviesResponse>,
                                   pagePosition: Long) {

        serviceApi.upcomingMovies(this.getKeyApi(), locationConfig.getLanguage(),
                                  pagePosition, locationConfig.getRegion())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { httpHandler.onComplete() }
                .doOnNext { httpHandler.onReceive(it) }
                .doOnError { httpHandler.onError(it) }
                .subscribe()
    }

}