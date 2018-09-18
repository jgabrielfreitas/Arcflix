package com.arctouch.codechallenge.ui.activity.splash

import com.arctouch.codechallenge.ui.activity.base.BaseView
import com.arctouch.codechallenge.ui.activity.base.HttpRequesterHandlerView
import com.arctouch.codechallenge.ui.activity.base.LoaderView

interface SplashView: BaseView, HttpRequesterHandlerView, LoaderView {

    fun onFinishRequest()

}