package com.jgabrielfreitas.infrastructure.persistence.cache

import com.jgabrielfreitas.infrastructure.persistence.preference.SharedPreferencesWrapper


class CacheRequirements {

    private val sharedPreferencesWrapper = SharedPreferencesWrapper<Boolean>()
    private val MOVIE_IDS_FLAG = "moviesIds"

    fun isAllRequirementsOk(): Boolean {
        sharedPreferencesWrapper.get(MOVIE_IDS_FLAG)?.let { return true } ?: run { return false }
    }

    fun markAsOk() = sharedPreferencesWrapper.save(MOVIE_IDS_FLAG, true)

}