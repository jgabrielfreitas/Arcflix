package com.arctouch.codechallenge.activity.home

import android.os.Bundle
import android.view.View
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.activity.base.BaseActivity
import com.arctouch.codechallenge.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.extension.toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : BaseNetworkActivity(), HomeView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.home_activity)

    serviceAPI.upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, 1, TmdbApi.DEFAULT_REGION)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
          val moviesWithGenres = it.results.map { movie ->
            movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
          }
          recyclerView.adapter = HomeAdapter(moviesWithGenres)
          progressBar.visibility = View.GONE
        }
  }

  override fun onStartSearch() {}

  override fun onStopSearch() {}
}
