package com.arctouch.codechallenge.di.module

import com.arctouch.codechallenge.infra.api.TmdbApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

  @Provides
  fun providesHttpClient(): OkHttpClient {

    val interceptor = HttpLoggingInterceptor().also{
      it.level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
                       .addInterceptor(interceptor)
                       .build()
  }

  @Provides
  fun providesRetrofit(httpClient: OkHttpClient): TmdbApi {
    return Retrofit.Builder()
                   .baseUrl(TmdbApi.URL)
                   .client(httpClient)
                   .addConverterFactory(MoshiConverterFactory.create())
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .build()
                   .create(TmdbApi::class.java)
  }

}
