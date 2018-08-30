package com.arctouch.codechallenge.activity.home

import android.os.Bundle
import android.view.View
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.di.component.DaggerHomeComponent
import com.arctouch.codechallenge.di.module.HomeModule
import com.arctouch.codechallenge.extension.toast
import com.arctouch.codechallenge.model.Movie
import kotlinx.android.synthetic.main.home_activity.*
import java.lang.Exception
import javax.inject.Inject

class HomeActivity : BaseNetworkActivity(), HomeView {

    @Inject lateinit var presenter: HomePresenter
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        recyclerView.adapter = HomeAdapter(movies)
        DaggerHomeComponent.builder()
                            .create(this)
                            .inject(this)
        presenter.onCreate(savedInstanceState)
    }

    override fun onStartSearch() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onStopSearch() {
        progressBar.visibility = View.GONE
    }

    override fun addMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        recyclerView.adapter.notifyDataSetChanged()
    }

    override fun onError(exception: Exception) {
        toast("ooops...")
        finish()
    }


}
