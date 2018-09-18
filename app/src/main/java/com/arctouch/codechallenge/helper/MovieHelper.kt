package com.arctouch.codechallenge.helper

import com.arctouch.codechallenge.util.DateUtils
import com.jgabrielfreitas.models.Genre
import com.jgabrielfreitas.models.Movie

class MovieHelper {

    fun releaseDate(movie: Movie) = DateUtils().convertStringToDate(movie.releaseDate)

    fun filterByCachedId(movieList: List<Movie>, cachedGenres: List<Genre>): List<Movie> {
        return movieList.map { movie ->
            movie.copy(genres = cachedGenres.filter { movie.genreIds?.contains(it.id) == true })
        }
    }
}