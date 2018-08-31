package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.activity.details.DetailsActivity
import com.arctouch.codechallenge.di.build.ActivityBuilder
import com.arctouch.codechallenge.di.module.DetailsModule
import dagger.Component
import dagger.android.AndroidInjector


@Component(modules = [(DetailsModule::class), (ActivityBuilder::class)])
interface DetailsComponent : AndroidInjector<DetailsActivity> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DetailsActivity>()
}