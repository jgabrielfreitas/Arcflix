package com.arctouch.codechallenge.ui.activity.main

import android.os.Bundle
import com.arctouch.codechallenge.di.component.DaggerMainComponent
import com.arctouch.codechallenge.ui.activity.base.BaseActivity
import com.arctouch.codechallenge.ui.activity.home.HomeActivity
import com.arctouch.codechallenge.ui.activity.splash.SplashActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.builder().create(this).inject(this)
        presenter.onCreate(savedInstanceState)
    }

    override fun startApplication() {
        doIntent(HomeActivity::class.java, shouldKillAfterIntent = true)
    }

    override fun loadMoviesIds() {
        doIntent(SplashActivity::class.java, shouldKillAfterIntent = true)
    }
}
