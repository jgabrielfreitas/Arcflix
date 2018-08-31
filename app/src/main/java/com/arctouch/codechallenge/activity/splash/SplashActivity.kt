package com.arctouch.codechallenge.activity.splash

import android.content.Intent
import android.os.Bundle
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.activity.base.BaseActivity
import com.arctouch.codechallenge.activity.home.HomeActivity
import com.jgabrielfreitas.infrastructure.api.TmdbApi
import com.jgabrielfreitas.infrastructure.data.Cache
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        api.genres(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Cache.cacheGenres(it.genres)
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
    }
}
