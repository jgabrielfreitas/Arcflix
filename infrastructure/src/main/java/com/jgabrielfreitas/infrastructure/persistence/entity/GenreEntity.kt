package com.jgabrielfreitas.infrastructure.persistence.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.jgabrielfreitas.models.Genre

@Entity(tableName = "Genre")
class GenreEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")   override val id: Int,
    @ColumnInfo(name = "name") override val name: String) : Genre(id, name)