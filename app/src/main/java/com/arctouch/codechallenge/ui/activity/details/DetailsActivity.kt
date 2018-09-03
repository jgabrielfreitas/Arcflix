package com.arctouch.codechallenge.ui.activity.details

import android.os.Bundle
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.di.component.DaggerDetailsComponent
import com.arctouch.codechallenge.extension.hide
import com.arctouch.codechallenge.extension.show
import com.arctouch.codechallenge.helper.MovieHelper
import com.arctouch.codechallenge.ui.activity.base.BaseNetworkActivity
import com.arctouch.codechallenge.util.MovieImageUrlBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jgabrielfreitas.models.Movie
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : BaseNetworkActivity(), DetailsView {

    @Inject lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        DaggerDetailsComponent.builder().create(this).inject(this)
        presenter.onCreate(intent.extras)
    }

    override fun showMovieData(movie: Movie) {
        Glide.with(this)
                .load(movie.posterPath?.let { MovieImageUrlBuilder().buildPosterUrl(it) })
                .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
                .into(posterImageView)
        titleTextView.text = movie.title
        genresTextView.text = movie.genres()
        releaseDateTextView.text = MovieHelper().releaseDate(movie)
        descriptionTextView.text = movie.overview
        reviewNoteTextView.text = movie.reviewNote()
        avgTimeTextView.text = movie.runtime()
    }

    override fun onStartSearch() = movieProgressBar.show()

    override fun onStopSearch() {
        movieProgressBar.hide()
        posterImageView.show()
        titleTextView.show()
        genresTextView.show()
        releaseDateTextView.show()
        reviewNoteTextView.show()
        avgTimeTextView.show()
        imageView.show()
        imageView2.show()
        scrollView.show()
    }
}
