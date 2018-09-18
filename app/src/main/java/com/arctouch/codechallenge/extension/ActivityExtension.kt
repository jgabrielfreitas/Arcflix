package com.arctouch.codechallenge.extension

import android.app.Activity
import android.widget.Toast.makeText
import android.widget.Toast.LENGTH_SHORT

fun Activity.toast(message:String, duration: Int = LENGTH_SHORT) = makeText(this, message, duration).show()