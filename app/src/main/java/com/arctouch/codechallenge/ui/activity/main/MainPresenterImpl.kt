package com.arctouch.codechallenge.ui.activity.main

import android.os.Bundle
import android.util.Log
import com.arctouch.codechallenge.ui.activity.base.BasePresenterImpl
import com.arctouch.codechallenge.ui.activity.base.PersistenceNeeded
import com.jgabrielfreitas.infrastructure.persistence.cache.CacheRequirements

class MainPresenterImpl(val mainView: MainView,
                        val cacheRequirements: CacheRequirements): BasePresenterImpl(mainView),
                                                                   MainPresenter,
                                                                   PersistenceNeeded {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (cacheRequirements.isAllRequirementsOk()) mainView.startApplication() else mainView.loadMoviesIds()
    }

}