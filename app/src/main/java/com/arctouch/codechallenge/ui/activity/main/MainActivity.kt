package com.arctouch.codechallenge.ui.activity.main

import android.content.Intent
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
        doIntent(HomeActivity::class.java)
    }

    override fun loadMoviesIds() {
        doIntent(SplashActivity::class.java)
    }

    private fun <T>  doIntent(cls: Class<T>) {
        with(Intent(this, cls)) {
            this@MainActivity.startActivity(this)
            finish()
        }
    }
}
