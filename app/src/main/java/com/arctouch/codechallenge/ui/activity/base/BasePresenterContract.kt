package com.arctouch.codechallenge.ui.activity.base

import android.os.Bundle

interface BasePresenterContract {

  fun onCreate(savedInstanceState: Bundle?)

  fun onStart()

  fun onResume()

  fun onPause()

  fun onStop()

  fun onDestroy()

}