package com.arctouch.codechallenge.ui.activity.base

import java.lang.Exception

interface HttpRequesterHandlerView {

    fun onError(exception: Exception)

}