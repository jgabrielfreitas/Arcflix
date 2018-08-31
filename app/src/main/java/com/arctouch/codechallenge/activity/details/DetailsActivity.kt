package com.arctouch.codechallenge.activity.details

import android.os.Bundle
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.activity.base.BaseActivity
import com.arctouch.codechallenge.model.Movie
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val movie = intent.extras.getParcelable<Movie>("movie")
    }
}
