package com.arctouch.codechallenge.ui.activity.base

import android.annotation.SuppressLint
import android.os.Bundle
import com.arctouch.codechallenge.di.component.DaggerNetworkComponent
import com.arctouch.codechallenge.di.module.NetworkModule
import com.jgabrielfreitas.infrastructure.api.TmdbApi
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseNetworkActivity : BaseActivity() {

  @Inject lateinit var serviceAPI: TmdbApi

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DaggerNetworkComponent.builder()
                          .networkModule(NetworkModule())
                          .build()
                          .inject(this)
  }

}