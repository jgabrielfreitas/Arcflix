package com.arctouch.codechallenge.ui.activity.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView {

    protected fun <T : BaseActivity>  doIntent(cls: Class<T>, map: HashMap<String, Long>?=null,
                                               shouldKillAfterIntent:Boolean?=false) {
        with(Intent(this, cls)) {
            map?.let { it.forEach { key, value -> this.putExtra(key, value) } }
            this@BaseActivity.startActivity(this)
            shouldKillAfterIntent?.let { if(shouldKillAfterIntent) finish() }
        }
    }
}
