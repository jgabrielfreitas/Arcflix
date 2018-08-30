package com.arctouch.codechallenge.activity.base

import android.os.Bundle

class BasePresenterImpl(view: BaseView) : BasePresenterContract {
  override fun onCreate(savedInstanceState: Bundle?) {}

  override fun onStart() {}

  override fun onResume() {}

  override fun onPause() {}

  override fun onStop() {}

  override fun onDestroy() {}
}