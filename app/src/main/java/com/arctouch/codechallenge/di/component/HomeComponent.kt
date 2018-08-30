package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.activity.home.HomeActivity
import com.arctouch.codechallenge.di.module.HomeModule
import dagger.Component

@Component(modules = [(HomeModule::class)])
interface HomeComponent {

    fun inject(homeActivity: HomeActivity)
}