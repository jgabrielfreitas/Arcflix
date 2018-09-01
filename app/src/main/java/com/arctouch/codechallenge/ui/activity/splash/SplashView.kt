package com.arctouch.codechallenge.ui.activity.splash

import com.arctouch.codechallenge.ui.activity.base.BaseView
import com.arctouch.codechallenge.ui.activity.base.LoaderView
import java.lang.Exception

interface SplashView: BaseView, LoaderView {

    fun onFinishRequest()

    fun onError(exception: Exception)

}