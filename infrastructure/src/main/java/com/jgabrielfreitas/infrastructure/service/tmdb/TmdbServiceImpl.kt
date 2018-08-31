package com.jgabrielfreitas.infrastructure.service.tmdb

import com.jgabrielfreitas.infrastructure.BuildConfig.API_KEY
import com.jgabrielfreitas.infrastructure.BuildConfig.BASE_URL
import com.jgabrielfreitas.infrastructure.HttpResponseHandler
import com.jgabrielfreitas.infrastructure.api.TmdbApi
import com.jgabrielfreitas.infrastructure.service.LocationConfigurationService
import com.jgabrielfreitas.models.Movie
import com.jgabrielfreitas.models.UpcomingMoviesResponse
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

    override fun getRemoteMovieDetails(httpHandler: HttpResponseHandler<Movie>, movieId: Long) {
        serviceApi.movie(movieId, getKeyApi(), locationConfig.getLanguage())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { httpHandler.onComplete() }
                .doOnNext { httpHandler.onReceive(it) }
                .doOnError { httpHandler.onError(it) }
                .subscribe()
    }


}