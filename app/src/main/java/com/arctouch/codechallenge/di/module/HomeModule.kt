package com.arctouch.codechallenge.di.module

import com.arctouch.codechallenge.activity.home.HomeActivity
import com.arctouch.codechallenge.activity.home.HomePresenter
import com.arctouch.codechallenge.activity.home.HomePresenterImpl
import com.arctouch.codechallenge.activity.home.HomeView
import com.arctouch.codechallenge.infra.api.TmdbApi
import dagger.Module
import dagger.Provides

@Module(includes = [(NetworkModule::class)])
class HomeModule {

    @Provides
    fun providesView(homeActivity: HomeActivity): HomeView {
        return homeActivity
    }

    @Provides
    fun providesPresenter(homeView: HomeView, serviceApi: TmdbApi): HomePresenter {
        return HomePresenterImpl(homeView, serviceApi)
    }

}