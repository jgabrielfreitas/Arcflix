package com.jgabrielfreitas.infrastructure.persistence.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.jgabrielfreitas.models.Genre

@Entity(tableName = "Genre")
class GenreEntity(
        @PrimaryKey
        @ColumnInfo(name = "ID") override var id: Int,
        @ColumnInfo(name = "NAME") override var name: String
) : Genre(id, name)