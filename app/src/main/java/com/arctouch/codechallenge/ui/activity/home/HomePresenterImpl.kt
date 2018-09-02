package com.arctouch.codechallenge.ui.activity.home

import android.os.Bundle
import com.arctouch.codechallenge.ui.activity.base.BasePresenterImpl
import com.arctouch.codechallenge.helper.MovieHelper
import com.jgabrielfreitas.infrastructure.HttpResponseHandler
import com.jgabrielfreitas.infrastructure.persistence.database.ApplicationDatabase
import com.jgabrielfreitas.infrastructure.persistence.entity.GenreEntity
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import com.jgabrielfreitas.models.Genre
import com.jgabrielfreitas.models.Movie
import com.jgabrielfreitas.models.UpcomingMoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class HomePresenterImpl(var view: HomeView,
                        var serviceApi: TmdbService,
                        var database: ApplicationDatabase) :
                                                   BasePresenterImpl(view),
                                                   HomePresenter,
                                                   HttpResponseHandler<UpcomingMoviesResponse> {

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
        database.genreDao().getAll()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { genreCached -> updateList(response.results, genreCached) }
                .subscribe()
    }

    private fun updateList(listFromApi: List<Movie>, cachedGenreEntity: List<GenreEntity>) {
        val filteredMovies = MovieHelper().filterByCachedId(listFromApi, transformList(cachedGenreEntity))
        view.addMovies(filteredMovies)
    }

    private fun transformList(genreEntityList: List<GenreEntity>) : List<Genre> {
        val genreList = mutableListOf<Genre>()
        genreEntityList.forEach { genreList.add(Genre(it.id, it.name)) }
        return genreList
    }

    override fun onError(throwable: Throwable) {
        view.onError(Exception("a exception occurs"))
    }

    override fun onMovieClicked(movie: Movie) {
        view.openMovieDetails(movie)
    }

}