package com.arctouch.codechallenge.ui.activity.base

import android.annotation.SuppressLint
import com.arctouch.codechallenge.ui.activity.fallback.ConnectionErrorActivity
import java.lang.Exception

@SuppressLint("Registered")
open class BaseNetworkActivity : BaseActivity(), HttpRequesterHandlerView {

  override fun onError(exception: Exception) {
    doIntent(ConnectionErrorActivity::class.java)
  }


}