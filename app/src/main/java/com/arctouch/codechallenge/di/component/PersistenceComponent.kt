package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.di.module.ContextModule
import com.arctouch.codechallenge.di.module.PersistenceModule
import com.arctouch.codechallenge.di.scope.ActivityScope
import com.arctouch.codechallenge.ui.activity.splash.SplashActivity
import dagger.Component

@ActivityScope
@Component(modules = [(PersistenceModule::class), (ContextModule::class)])
interface PersistenceComponent {

    fun inject(splashActivity: SplashActivity)

}