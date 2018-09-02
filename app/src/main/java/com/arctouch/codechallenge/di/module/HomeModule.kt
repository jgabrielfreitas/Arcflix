package com.arctouch.codechallenge.di.module

import android.content.Context
import com.arctouch.codechallenge.ui.activity.home.HomeActivity
import com.arctouch.codechallenge.ui.activity.home.HomePresenter
import com.arctouch.codechallenge.ui.activity.home.HomePresenterImpl
import com.arctouch.codechallenge.ui.activity.home.HomeView
import com.jgabrielfreitas.infrastructure.persistence.database.ApplicationDatabase
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import dagger.Module
import dagger.Provides

@Module(includes = [(NetworkModule::class),
                    (TmdbServiceApiModule::class),
                    (PersistenceModule::class)])
class HomeModule {

    @Provides
    fun providesContext(homeActivity: HomeActivity): Context {
        return homeActivity
    }

    @Provides
    fun providesView(homeActivity: HomeActivity): HomeView {
        return homeActivity
    }

    @Provides
    fun providesPresenter(homeView: HomeView,
                          serviceApi:TmdbService,
                          applicationDatabase: ApplicationDatabase): HomePresenter {
        return HomePresenterImpl(homeView, serviceApi, applicationDatabase)
    }

}