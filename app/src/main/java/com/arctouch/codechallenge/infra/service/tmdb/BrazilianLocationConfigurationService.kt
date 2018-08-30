package com.arctouch.codechallenge.infra.service.tmdb

import com.arctouch.codechallenge.infra.service.LocationConfigurationService

class BrazilianLocationConfigurationService: LocationConfigurationService {
    override fun getLanguage(): String {
        return "pt-BR"
    }

    override fun getRegion(): String {
        return "BR"
    }
}