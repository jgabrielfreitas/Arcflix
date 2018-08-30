package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.activity.home.HomeActivity
import com.arctouch.codechallenge.di.build.ActivityBuilder
import com.arctouch.codechallenge.di.module.HomeModule
import dagger.Component
import dagger.android.AndroidInjector


@Component(modules = [(HomeModule::class), (ActivityBuilder::class)])
interface HomeComponent : AndroidInjector<HomeActivity> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>()
}