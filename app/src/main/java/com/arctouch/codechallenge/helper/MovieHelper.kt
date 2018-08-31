package com.arctouch.codechallenge.helper

import com.arctouch.codechallenge.util.DateUtils
import com.jgabrielfreitas.infrastructure.data.Cache
import com.jgabrielfreitas.models.Movie

class MovieHelper {

    fun releaseDate(movie: Movie) = DateUtils().convertStringToDate(movie.releaseDate)

    fun filterMoviesCachedIds(movieList: List<Movie>): List<Movie> {
        return movieList.map { movie ->
            movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
        }
    }
}