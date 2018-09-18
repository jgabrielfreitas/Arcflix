package com.arctouch.codechallenge.listener

import android.support.v7.widget.RecyclerView

interface EndlessScrollListener {

    fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView)
}