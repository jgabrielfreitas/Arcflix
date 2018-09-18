package com.jgabrielfreitas.infrastructure.persistence.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Genre")
class GenreEntity(
        @PrimaryKey
        var id: Int,
        var name: String
)