package com.jgabrielfreitas.infrastructure.service


interface Service {

    fun getBaseUrl(): String

    fun getKeyApi(): String?

}