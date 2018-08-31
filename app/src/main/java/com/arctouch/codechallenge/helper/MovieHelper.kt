package com.arctouch.codechallenge.helper

import com.arctouch.codechallenge.infra.data.Cache
import com.arctouch.codechallenge.model.Movie

class MovieHelper {

    fun filterMoviesCachedIds(movieList: List<Movie>): List<Movie> {
        return movieList.map { movie ->
            movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
        }
    }
}