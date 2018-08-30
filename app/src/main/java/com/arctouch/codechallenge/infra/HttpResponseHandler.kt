package com.arctouch.codechallenge.infra

interface HttpResponseHandler<in T> {

    fun onReceive(response: T)

    fun onComplete()

    fun onError(throwable: Throwable)

}