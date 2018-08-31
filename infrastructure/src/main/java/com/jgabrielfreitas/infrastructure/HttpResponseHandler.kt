package com.jgabrielfreitas.infrastructure

interface HttpResponseHandler<in T> {

    fun onReceive(response: T)

    fun onComplete()

    fun onError(throwable: Throwable)

}