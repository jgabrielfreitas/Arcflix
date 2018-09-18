package com.jgabrielfreitas.infrastructure.service.tmdb

import com.jgabrielfreitas.infrastructure.service.LocationConfigurationService

class BrazilianLocationConfigurationService: LocationConfigurationService {
    override fun getLanguage(): String {
        return "pt-BR"
    }

    override fun getRegion(): String {
        return "BR"
    }
}