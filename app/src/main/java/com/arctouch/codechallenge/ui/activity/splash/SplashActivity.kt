package com.arctouch.codechallenge.ui.activity.splash

import android.os.Bundle
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.di.component.DaggerSplashComponent
import com.arctouch.codechallenge.extension.hide
import com.arctouch.codechallenge.extension.show
import com.arctouch.codechallenge.ui.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.ui.activity.base.PersistenceNeeded
import com.arctouch.codechallenge.ui.activity.home.HomeActivity
import kotlinx.android.synthetic.main.splash_activity.*
import javax.inject.Inject

class SplashActivity : BaseNetworkActivity(), SplashView, PersistenceNeeded {

    @Inject lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        DaggerSplashComponent.builder().create(this).inject(this)
        presenter.onCreate(savedInstanceState)
    }

    override fun onStartSearch() = genreProgressBar.show()

    override fun onStopSearch() = genreProgressBar.hide()

    override fun onFinishRequest() {
        doIntent(HomeActivity::class.java, shouldKillAfterIntent = true)
    }

}
