package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.ui.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.di.module.NetworkModule
import dagger.Component

@Component(modules = [(NetworkModule::class)])
interface NetworkComponent {

  fun inject(networkActivity: BaseNetworkActivity)

}