package com.arctouch.codechallenge.ui.activity.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.activity.details.DetailsActivity
import com.arctouch.codechallenge.di.component.DaggerHomeComponent
import com.arctouch.codechallenge.extension.toast
import com.arctouch.codechallenge.listener.EndlessScroll
import kotlinx.android.synthetic.main.home_activity.*
import java.lang.Exception
import javax.inject.Inject
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.arctouch.codechallenge.listener.EndlessScrollListener
import com.arctouch.codechallenge.R.string.default_error_message
import com.jgabrielfreitas.models.Movie


class HomeActivity : BaseNetworkActivity(), HomeView, EndlessScrollListener {

    @Inject lateinit var presenter: HomePresenter
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        DaggerHomeComponent.builder().apply {
            create(this@HomeActivity).apply { inject(this@HomeActivity) }
        }
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

    override fun onError(exception: Exception) = toast(resources.getString(default_error_message))

    override fun addMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        recyclerView.adapter.notifyDataSetChanged()
    }

    override fun openMovieDetails(movie: Movie) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("movieId", movie.id)
        }
        startActivity(intent)
    }

    override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
        presenter.requestUpcomingMovies(page.toLong())
    }

}
