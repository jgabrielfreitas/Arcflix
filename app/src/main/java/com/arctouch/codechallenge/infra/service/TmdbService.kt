package com.arctouch.codechallenge.infra.service

import com.arctouch.codechallenge.infra.HttpResponseHandler
import com.arctouch.codechallenge.model.UpcomingMoviesResponse

interface TmdbService: Service {

    fun getUpcomingMovies(httpHandler: HttpResponseHandler<UpcomingMoviesResponse>,
                          language: String,
                          region: String,
                          pagePosition: Long)
}