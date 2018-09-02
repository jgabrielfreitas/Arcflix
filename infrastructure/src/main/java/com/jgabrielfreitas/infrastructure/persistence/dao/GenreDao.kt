package com.jgabrielfreitas.infrastructure.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.jgabrielfreitas.infrastructure.persistence.entity.GenreEntity
import io.reactivex.Flowable

@Dao
abstract class GenreDao : BaseDao<GenreEntity>() {

  @Query("SELECT * FROM Genre")
  abstract fun getAll(): Flowable<List<GenreEntity>>

}