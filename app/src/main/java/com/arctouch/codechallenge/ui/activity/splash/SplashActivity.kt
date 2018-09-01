package com.arctouch.codechallenge.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.extension.hide
import com.arctouch.codechallenge.extension.show
import com.arctouch.codechallenge.ui.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.ui.activity.home.HomeActivity
import com.jgabrielfreitas.infrastructure.persistence.database.ApplicationDatabase
import kotlinx.android.synthetic.main.splash_activity.*
import javax.inject.Inject

class SplashActivity : BaseNetworkActivity(), SplashView {

    @Inject lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
    }

    override fun onStartSearch() = genreProgressBar.show()

    override fun onStopSearch() = genreProgressBar.hide()

    override fun onFinishRequest() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
    }
}
