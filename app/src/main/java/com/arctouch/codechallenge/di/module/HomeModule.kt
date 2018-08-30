package com.arctouch.codechallenge.di.module

import com.arctouch.codechallenge.activity.home.HomePresenter
import com.arctouch.codechallenge.activity.home.HomePresenterImpl
import com.arctouch.codechallenge.activity.home.HomeView
import com.arctouch.codechallenge.infra.api.TmdbApi
import dagger.Module
import dagger.Provides

@Module(includes = [(NetworkModule::class)])
class HomeModule(var homeView: HomeView) {

    @Provides
    fun providesPresenter(serviceApi: TmdbApi): HomePresenter {
        return HomePresenterImpl(homeView, serviceApi)
    }

}