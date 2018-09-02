package com.arctouch.codechallenge

import android.app.Application
import com.orhanobut.hawk.Hawk

class ChallengeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
    }
}