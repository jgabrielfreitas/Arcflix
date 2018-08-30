package com.arctouch.codechallenge.infra.service.tmdb

import com.arctouch.codechallenge.infra.HttpResponseHandler
import com.arctouch.codechallenge.infra.service.Service
import com.arctouch.codechallenge.model.UpcomingMoviesResponse

interface TmdbService: Service {

    fun getUpcomingMovies(httpHandler: HttpResponseHandler<UpcomingMoviesResponse>,
                          pagePosition: Long)
}