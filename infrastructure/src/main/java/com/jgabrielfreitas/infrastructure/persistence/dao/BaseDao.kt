package com.jgabrielfreitas.infrastructure.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Update

@Dao
abstract class BaseDao<in T> {

  @Insert(onConflict = REPLACE)
  abstract fun insert(type: T): Long

  @Update
  abstract fun update(type: T)

  @Delete
  abstract fun delete(type: T)
}