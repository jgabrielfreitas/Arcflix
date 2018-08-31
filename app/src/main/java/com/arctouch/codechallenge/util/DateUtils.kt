package com.arctouch.codechallenge.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat


class DateUtils {

    @SuppressLint("SimpleDateFormat")
    fun convertStringToDate(dateAsString: String?): String? {
        dateAsString?.let {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            val date = simpleDateFormat.parse(dateAsString)
            return SimpleDateFormat("dd/MM/yyyy").format(date)
        }
        return "--"
    }

}