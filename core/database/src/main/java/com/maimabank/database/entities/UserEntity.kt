package com.maimabank.database.entities

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
@Keep
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String,
    val email: String,
    val password: String,
    val phoneNumber: String?,
    val createdAt: Long,
    val updatedAt: Long?
)
