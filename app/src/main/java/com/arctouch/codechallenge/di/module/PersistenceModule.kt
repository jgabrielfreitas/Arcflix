package com.arctouch.codechallenge.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.jgabrielfreitas.infrastructure.persistence.cache.CacheRequirements
import com.jgabrielfreitas.infrastructure.persistence.database.ApplicationDatabase
import dagger.Module
import dagger.Provides

@Module
class PersistenceModule {

    @Provides
    fun providesCacheRequirements(): CacheRequirements {
        return CacheRequirements()
    }

    @Provides
    fun providesDatabase(context: Context): ApplicationDatabase {
        return Room.databaseBuilder(context,
                                    ApplicationDatabase::class.java,
                             "application_database.db").
                                    fallbackToDestructiveMigration()
                                    .build()
    }

}