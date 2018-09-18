package com.arctouch.codechallenge.di.module

import com.arctouch.codechallenge.ui.activity.details.DetailsActivity
import com.arctouch.codechallenge.ui.activity.details.DetailsPresenter
import com.arctouch.codechallenge.ui.activity.details.DetailsPresenterImpl
import com.arctouch.codechallenge.ui.activity.details.DetailsView
import com.jgabrielfreitas.infrastructure.api.TmdbApi
import com.jgabrielfreitas.infrastructure.service.LocationConfigurationService
import com.jgabrielfreitas.infrastructure.service.tmdb.BrazilianLocationConfigurationService
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbServiceImpl
import dagger.Module
import dagger.Provides

@Module(includes = [(NetworkModule::class), (TmdbServiceApiModule::class)])
class DetailsModule {

    @Provides
    fun providesView(detailsActivity: DetailsActivity): DetailsView {
        return detailsActivity
    }

    @Provides
    fun providesPresenter(detailsView: DetailsView, serviceApi: TmdbService): DetailsPresenter {
        return DetailsPresenterImpl(detailsView, serviceApi)
    }

}