package com.jgabrielfreitas.infrastructure.persistence.preference

import com.orhanobut.hawk.Hawk

class SharedPreferencesWrapper<T> {

    fun save(key:String, content: T) = Hawk.put(key, content)

    fun get(key:String) : T? = Hawk.get(key)
}