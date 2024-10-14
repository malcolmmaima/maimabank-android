package com.maimabank.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maimabank.database.entities.UserEntity

@Database(
    version = 1,
    entities = [UserEntity::class],
    exportSchema = false
)
abstract class MaimaBankDatabase : RoomDatabase() {
}
