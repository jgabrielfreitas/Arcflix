package com.arctouch.codechallenge.ui.activity.base

import android.support.v7.app.AppCompatActivity
import com.jgabrielfreitas.infrastructure.api.TmdbApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class BaseActivity : AppCompatActivity(), BaseView
