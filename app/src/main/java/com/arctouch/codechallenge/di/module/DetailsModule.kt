package com.arctouch.codechallenge.di.module

import com.arctouch.codechallenge.activity.details.DetailsActivity
import com.arctouch.codechallenge.activity.details.DetailsPresenter
import com.arctouch.codechallenge.activity.details.DetailsPresenterImpl
import com.arctouch.codechallenge.activity.details.DetailsView
import com.arctouch.codechallenge.activity.home.HomeActivity
import com.arctouch.codechallenge.activity.home.HomePresenter
import com.arctouch.codechallenge.activity.home.HomePresenterImpl
import com.arctouch.codechallenge.activity.home.HomeView
import com.arctouch.codechallenge.infra.service.tmdb.TmdbService
import com.arctouch.codechallenge.infra.service.tmdb.TmdbServiceImpl
import com.arctouch.codechallenge.infra.api.TmdbApi
import com.arctouch.codechallenge.infra.service.LocationConfigurationService
import com.arctouch.codechallenge.infra.service.tmdb.BrazilianLocationConfigurationService
import dagger.Module
import dagger.Provides

@Module(includes = [(NetworkModule::class)])
class DetailsModule {

    @Provides
    fun providesLocationConfiguration(): LocationConfigurationService {
        return BrazilianLocationConfigurationService()
    }

    @Provides
    fun providesTmdbService(serviceApi: TmdbApi, config: LocationConfigurationService): TmdbService {
        return TmdbServiceImpl(serviceApi, config)
    }

    @Provides
    fun providesView(detailsActivity: DetailsActivity): DetailsView {
        return detailsActivity
    }

    @Provides
    fun providesPresenter(detailsView: DetailsView, serviceApi: TmdbService): DetailsPresenter {
        return DetailsPresenterImpl(detailsView, serviceApi)
    }

}