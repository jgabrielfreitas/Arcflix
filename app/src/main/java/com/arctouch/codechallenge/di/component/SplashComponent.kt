package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.di.build.ActivityBuilder
import com.arctouch.codechallenge.di.module.SplashModule
import com.arctouch.codechallenge.di.scope.ActivityScope
import com.arctouch.codechallenge.ui.activity.splash.SplashActivity
import dagger.Component
import dagger.android.AndroidInjector

@Component(modules = [(SplashModule::class), (ActivityBuilder::class)])
interface SplashComponent : AndroidInjector<SplashActivity> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SplashActivity>()
}