package com.jgabrielfreitas.infrastructure.persistence.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.jgabrielfreitas.infrastructure.persistence.dao.GenreDao
import com.jgabrielfreitas.infrastructure.persistence.entity.GenreEntity

@Database(entities = [(GenreEntity::class)], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {

  abstract fun genreDao(): GenreDao
}
