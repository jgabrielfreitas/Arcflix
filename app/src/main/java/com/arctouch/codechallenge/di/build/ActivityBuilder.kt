package com.arctouch.codechallenge.di.build

import android.app.Activity
import com.arctouch.codechallenge.di.component.DetailsComponent
import com.arctouch.codechallenge.di.component.HomeComponent
import com.arctouch.codechallenge.di.component.MainComponent
import com.arctouch.codechallenge.ui.activity.details.DetailsActivity
import com.arctouch.codechallenge.ui.activity.home.HomeActivity
import com.arctouch.codechallenge.ui.activity.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    internal abstract fun bindHomeActivity(builder: HomeComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivity(builder: MainComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(DetailsActivity::class)
    internal abstract fun bindDetailsActivity(builder: DetailsComponent.Builder): AndroidInjector.Factory<out Activity>


}
