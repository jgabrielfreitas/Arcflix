package com.arctouch.codechallenge.ui.activity.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.di.component.DaggerHomeComponent
import com.arctouch.codechallenge.listener.EndlessScroll
import com.arctouch.codechallenge.listener.EndlessScrollListener
import com.arctouch.codechallenge.ui.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.ui.activity.details.DetailsActivity
import com.jgabrielfreitas.models.Movie
import kotlinx.android.synthetic.main.home_activity.*
import javax.inject.Inject


class HomeActivity : BaseNetworkActivity(), HomeView, EndlessScrollListener {

    @Inject lateinit var presenter: HomePresenter
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        DaggerHomeComponent.builder().create(this).inject(this)
        prepareUi()
        presenter.onCreate(savedInstanceState)
    }

    private fun prepareUi() {
        val linearLayoutManager = LinearLayoutManager(this)
        val homeAdapter = HomeAdapter(movies).apply {
            onItemClick = { movie -> presenter.onMovieClicked(movie) }
        }
        recyclerView.apply {
            adapter = homeAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(EndlessScroll(linearLayoutManager, this@HomeActivity))
        }
    }

    override fun onStartSearch() = progressBar.run { visibility = View.VISIBLE }

    override fun onStopSearch() = progressBar.run { visibility = View.GONE }

    override fun addMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        recyclerView.adapter.notifyDataSetChanged()
    }

    override fun openMovieDetails(movie: Movie) {
        doIntent(DetailsActivity::class.java, hashMapOf(Pair("movieId", movie.id)))
    }

    override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
        presenter.requestUpcomingMovies(page.toLong())
    }

}
