package com.maimabank.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maimabank.database.convertors.MoneyAmountConvertor
import com.maimabank.database.entities.CardEntity
import com.maimabank.database.entities.TransactionEntity
import com.maimabank.database.entities.UserEntity

@Database(
    version = 1,
    entities = [UserEntity::class,
               CardEntity::class,
               TransactionEntity::class],
    exportSchema = false
)
@TypeConverters(MoneyAmountConvertor::class)
abstract class MaimaBankDatabase : RoomDatabase() {
}
