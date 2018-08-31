package com.jgabrielfreitas.models

import com.squareup.moshi.Json

data class Movie(
    val id: Long,
    val title: String,
    val overview: String?,
    val genres: List<Genre>?,
    @Json(name = "genre_ids") val genreIds: List<Int>?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "vote_average") val voteAverage: Double,
    val runtime: Int?
) {
  fun reviewNote() = "$voteAverage/10"

  fun runtime() = "${runtime?.toString() ?: "--"}m"

  fun genres() = genres?.joinToString(separator = ", ") { it.name }
}