package com.arctouch.codechallenge.di.module

import com.arctouch.codechallenge.ui.activity.main.MainActivity
import com.arctouch.codechallenge.ui.activity.main.MainPresenter
import com.arctouch.codechallenge.ui.activity.main.MainPresenterImpl
import com.arctouch.codechallenge.ui.activity.main.MainView
import com.jgabrielfreitas.infrastructure.persistence.cache.CacheRequirements
import dagger.Module
import dagger.Provides

@Module(includes = [(PersistenceModule::class)])
class MainModule {

    @Provides
    fun providesView(mainActivity: MainActivity): MainView {
        return mainActivity
    }

    @Provides
    fun providesMainPresenter(mainView: MainView, cacheRequirements: CacheRequirements): MainPresenter {
        return MainPresenterImpl(mainView, cacheRequirements)
    }
}