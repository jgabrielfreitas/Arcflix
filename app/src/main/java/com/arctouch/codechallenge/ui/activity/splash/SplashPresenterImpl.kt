package com.arctouch.codechallenge.ui.activity.splash

import android.os.Bundle
import com.arctouch.codechallenge.ui.activity.base.BasePresenterImpl
import com.jgabrielfreitas.infrastructure.HttpResponseHandler
import com.jgabrielfreitas.infrastructure.persistence.cache.CacheRequirements
import com.jgabrielfreitas.infrastructure.persistence.database.ApplicationDatabase
import com.jgabrielfreitas.infrastructure.persistence.entity.GenreEntity
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import com.jgabrielfreitas.models.Genre
import com.jgabrielfreitas.models.GenreResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class SplashPresenterImpl(val splashView: SplashView,
                          val tmdbApi   : TmdbService,
                          val database  : ApplicationDatabase,
                          val cacheRequirements: CacheRequirements): BasePresenterImpl(splashView),
                                                            SplashPresenter, HttpResponseHandler<GenreResponse> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tmdbApi.getGenres(this)
        splashView.onStartSearch()
    }

    override fun onReceive(response: GenreResponse) {
        Observable.fromCallable { persistGenres(response.genres) }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    override fun onComplete() = splashView.onFinishRequest()

    override fun onError(throwable: Throwable) = splashView.onError(Exception("wow"))

    private fun persistGenres(genres: List<Genre>) {
        val gerenDao = database.genreDao()
        genres.forEach {  gerenDao.insert(GenreEntity(it.id, it.name)) }
        cacheRequirements.markAsOk()
    }
}