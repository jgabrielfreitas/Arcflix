package com.arctouch.codechallenge.activity.details

import android.os.Bundle
import android.view.View
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.activity.base.BaseActivity
import com.arctouch.codechallenge.di.component.DaggerDetailsComponent
import com.arctouch.codechallenge.extension.toast
import com.arctouch.codechallenge.model.Movie
import com.arctouch.codechallenge.util.MovieImageUrlBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_details.*
import java.lang.Exception
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsView {

    @Inject
    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        DaggerDetailsComponent.builder().apply {
            create(this@DetailsActivity).apply { inject(this@DetailsActivity) }
        }
        presenter.onCreate(intent.extras)
    }

    override fun showMovieData(movie: Movie) {
        Glide.with(this)
                .load(movie.posterPath?.let { MovieImageUrlBuilder().buildPosterUrl(it) })
                .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
                .into(posterImageView)
        titleTextView.text = movie.title
        genresTextView.text = movie.genres?.joinToString(separator = ", ") { it.name }
        releaseDateTextView.text = movie.releaseDate
        descriptionTextView.text = movie.overview
        reviewNoteTextView.text = movie.reviewNote()
        avgTimeTextView.text = movie.runtime()
    }

    override fun onError(exception: Exception) = toast(resources.getString(R.string.default_error_message))

    override fun onStartSearch() = movieProgressBar.run { visibility = View.VISIBLE }

    override fun onStopSearch() {
        movieProgressBar.run { visibility = View.GONE }
        posterImageView.run { visibility = View.VISIBLE }
        titleTextView.run { visibility = View.VISIBLE }
        genresTextView.run { visibility = View.VISIBLE }
        releaseDateTextView.run { visibility = View.VISIBLE }
        reviewNoteTextView.run { visibility = View.VISIBLE }
        avgTimeTextView.run { visibility = View.VISIBLE }
        imageView.run { visibility = View.VISIBLE }
        imageView2.run { visibility = View.VISIBLE }
        scrollView.run { visibility = View.VISIBLE }
    }
}
