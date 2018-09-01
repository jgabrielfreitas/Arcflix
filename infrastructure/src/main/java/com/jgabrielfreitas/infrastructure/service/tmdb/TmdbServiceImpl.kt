package com.jgabrielfreitas.infrastructure.service.tmdb

import com.jgabrielfreitas.infrastructure.BuildConfig.API_KEY
import com.jgabrielfreitas.infrastructure.BuildConfig.BASE_URL
import com.jgabrielfreitas.infrastructure.HttpResponseHandler
import com.jgabrielfreitas.infrastructure.api.TmdbApi
import com.jgabrielfreitas.infrastructure.service.LocationConfigurationService
import com.jgabrielfreitas.models.GenreResponse
import com.jgabrielfreitas.models.Movie
import com.jgabrielfreitas.models.UpcomingMoviesResponse
import io.reactivex.Observable
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

    private fun <T> subscribe(httpHandler: HttpResponseHandler<T>, observable: Observable<T>) {
        observable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .doOnComplete { httpHandler.onComplete() }
                  .doOnNext { httpHandler.onReceive(it) }
                  .doOnError { httpHandler.onError(it) }
                  .subscribe()
    }

    override fun getUpcomingMovies(httpHandler: HttpResponseHandler<UpcomingMoviesResponse>,
                                   pagePosition: Long) {
        subscribe(httpHandler, serviceApi.upcomingMovies(this.getKeyApi(),
                                                         locationConfig.getLanguage(),
                                                         pagePosition,
                                                         locationConfig.getRegion()))
    }

    override fun getRemoteMovieDetails(httpHandler: HttpResponseHandler<Movie>, movieId: Long) {
        subscribe(httpHandler, serviceApi.movie(movieId, getKeyApi(), locationConfig.getLanguage()))
    }

    override fun getGenres(httpHandler: HttpResponseHandler<GenreResponse>) {
        subscribe(httpHandler, serviceApi.genres(getKeyApi(), locationConfig.getLanguage()))
    }


}