package com.jgabrielfreitas.infrastructure.service.tmdb

import com.jgabrielfreitas.infrastructure.HttpResponseHandler
import com.jgabrielfreitas.infrastructure.service.Service
import com.jgabrielfreitas.models.GenreResponse
import com.jgabrielfreitas.models.Movie
import com.jgabrielfreitas.models.UpcomingMoviesResponse

interface TmdbService: Service {

    fun getUpcomingMovies(httpHandler: HttpResponseHandler<UpcomingMoviesResponse>,
                          pagePosition: Long)

    fun getRemoteMovieDetails(httpHandler: HttpResponseHandler<Movie>, movieId: Long)

    fun getGenres(httpHandler: HttpResponseHandler<GenreResponse>)
}