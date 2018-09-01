package com.arctouch.codechallenge.di.module

import android.content.Context
import com.arctouch.codechallenge.di.scope.ActivityScope
import dagger.Module
import dagger.Provides


@Module
class ContextModule(private var context: Context) {

    @Provides
    @ActivityScope
    fun providesContext(): Context {
        return context
    }
}