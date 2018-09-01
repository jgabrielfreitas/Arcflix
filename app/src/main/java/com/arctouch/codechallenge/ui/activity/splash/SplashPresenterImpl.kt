package com.arctouch.codechallenge.ui.activity.splash

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import com.arctouch.codechallenge.ui.activity.base.BasePresenterImpl
import com.jgabrielfreitas.infrastructure.HttpResponseHandler
import com.jgabrielfreitas.infrastructure.persistence.database.ApplicationDatabase
import com.jgabrielfreitas.infrastructure.persistence.entity.GenreEntity
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import com.jgabrielfreitas.models.Genre
import com.jgabrielfreitas.models.GenreResponse

class SplashPresenterImpl(val splashView: SplashView,
                          val tmdbApi   : TmdbService,
                          val database  : ApplicationDatabase): BasePresenterImpl(splashView),
                                                            SplashPresenter, HttpResponseHandler<GenreResponse> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tmdbApi.getGenres(this)
        splashView.onStartSearch()
        AsyncTask.execute { database.genreDao().getAll().forEach { Log.e("genre", it.toString()) } }
    }

    override fun onReceive(response: GenreResponse) {
        AsyncTask.execute { persisteGenres(response.genres) }
    }

    override fun onComplete() = splashView.onFinishRequest()

    override fun onError(throwable: Throwable) = splashView.onError(Exception("wow"))

    private fun persisteGenres(genres: List<Genre>) {
        val gerenDao = database.genreDao()
        genres.forEach {  gerenDao.insert(GenreEntity(it.id, it.name)) }
    }
}