package com.arctouch.codechallenge.ui.activity.fallback

import android.os.Bundle
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.ui.activity.base.BaseActivity

class ConnectionErrorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection_error)
    }
}
