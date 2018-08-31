package com.jgabrielfreitas.infrastructure.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.jgabrielfreitas.infrastructure.persistence.entity.GenreEntity

@Dao
abstract class GenreDao : BaseDao<GenreEntity>() {

  @Query("SELECT * FROM Genre")
  abstract fun getAll(): List<GenreEntity>

}