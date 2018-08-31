package com.arctouch.codechallenge.di.module

import com.arctouch.codechallenge.activity.home.HomeActivity
import com.arctouch.codechallenge.activity.home.HomePresenter
import com.arctouch.codechallenge.activity.home.HomePresenterImpl
import com.arctouch.codechallenge.activity.home.HomeView
import com.jgabrielfreitas.infrastructure.api.TmdbApi
import com.jgabrielfreitas.infrastructure.service.LocationConfigurationService
import com.jgabrielfreitas.infrastructure.service.tmdb.BrazilianLocationConfigurationService
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbServiceImpl
import dagger.Module
import dagger.Provides

@Module(includes = [(NetworkModule::class)])
class HomeModule {

    @Provides
    fun providesLocationConfiguration(): LocationConfigurationService {
        return BrazilianLocationConfigurationService()
    }

    @Provides
    fun providesTmdbService(serviceApi: TmdbApi, config: LocationConfigurationService): TmdbService {
        return TmdbServiceImpl(serviceApi, config)
    }

    @Provides
    fun providesView(homeActivity: HomeActivity): HomeView {
        return homeActivity
    }

    @Provides
    fun providesPresenter(homeView: HomeView, serviceApi: TmdbService): HomePresenter {
        return HomePresenterImpl(homeView, serviceApi)
    }

}