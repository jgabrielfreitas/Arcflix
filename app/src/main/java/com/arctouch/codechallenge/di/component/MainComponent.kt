package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.di.build.ActivityBuilder
import com.arctouch.codechallenge.di.module.MainModule
import com.arctouch.codechallenge.ui.activity.main.MainActivity
import dagger.Component
import dagger.android.AndroidInjector

@Component(modules = [(MainModule::class), ActivityBuilder::class])
interface MainComponent : AndroidInjector<MainActivity> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}