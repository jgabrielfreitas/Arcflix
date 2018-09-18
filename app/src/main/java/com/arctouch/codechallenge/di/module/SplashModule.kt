package com.arctouch.codechallenge.di.module

import android.content.Context
import com.arctouch.codechallenge.ui.activity.splash.SplashActivity
import com.arctouch.codechallenge.ui.activity.splash.SplashPresenter
import com.arctouch.codechallenge.ui.activity.splash.SplashPresenterImpl
import com.arctouch.codechallenge.ui.activity.splash.SplashView
import com.jgabrielfreitas.infrastructure.persistence.cache.CacheRequirements
import com.jgabrielfreitas.infrastructure.persistence.database.ApplicationDatabase
import com.jgabrielfreitas.infrastructure.service.tmdb.TmdbService
import dagger.Module
import dagger.Provides

@Module(includes = [(NetworkModule::class),
                    (TmdbServiceApiModule::class),
                    (PersistenceModule::class)])
class SplashModule {

    @Provides
    fun providesContext(splashActivity: SplashActivity): Context {
        return splashActivity
    }

    @Provides
    fun providesSplashView(splashActivity: SplashActivity) : SplashView {
        return splashActivity
    }

    @Provides
    fun providesPresenter(splashView: SplashView,
                          tmdbApi   : TmdbService,
                          database  : ApplicationDatabase,
                          cacheRequirements: CacheRequirements): SplashPresenter {
        return SplashPresenterImpl(splashView, tmdbApi, database, cacheRequirements)
    }

}