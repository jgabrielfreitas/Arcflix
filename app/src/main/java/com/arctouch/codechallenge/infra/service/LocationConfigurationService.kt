package com.arctouch.codechallenge.infra.service

interface LocationConfigurationService {

    fun getLanguage(): String

    fun getRegion(): String

}