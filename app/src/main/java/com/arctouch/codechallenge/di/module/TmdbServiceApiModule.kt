package com.arctouch.codechallenge.di.module

import com.jgabrielfreitas.infrastructure.api.TmdbApi
import com.jgabrielfreitas.infrastructure.service.LocationConfigurationService
import com.jgabrielfreitas.infrastructure.service.tmdb.BrazilianLocationConfigurationService
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbServiceImpl
import dagger.Module
import dagger.Provides

@Module
class TmdbServiceApiModule {

    @Provides
    fun providesLocationConfiguration(): LocationConfigurationService {
        return BrazilianLocationConfigurationService()
    }

    @Provides
    fun providesTmdbService(serviceApi: TmdbApi, config: LocationConfigurationService): TmdbService {
        return TmdbServiceImpl(serviceApi, config)
    }

}