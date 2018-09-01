package com.arctouch.codechallenge.extension

import android.view.View

fun View.hide() {
    this.let { visibility = View.GONE }
}

fun View.show() {
    this.let { visibility = View.VISIBLE }
}