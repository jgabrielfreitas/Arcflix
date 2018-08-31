package com.jgabrielfreitas.infrastructure.data

import com.jgabrielfreitas.models.Genre

object Cache {

    var genres = listOf<Genre>()

    fun cacheGenres(genres: List<Genre>) {
        Cache.genres = genres
    }
}
