package com.maimabank.database.di

import android.content.Context
import androidx.room.Room
import com.maimabank.database.MaimaBankDatabase
import com.maimabank.database.migrations.MaimaBankDatabaseMigrations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {

    @Singleton
    @Provides
    fun provideBankDatabase(
        @ApplicationContext context: Context
    ): MaimaBankDatabase = Room.databaseBuilder(
        context = context,
        name = "maimabankdatabase.db",
        klass = MaimaBankDatabase::class.java
    ).addMigrations(MaimaBankDatabaseMigrations.migrations_1_2)
        .fallbackToDestructiveMigration()
        .build()
}
