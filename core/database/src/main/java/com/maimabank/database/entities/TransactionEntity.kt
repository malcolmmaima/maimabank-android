package com.maimabank.database.entities

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maimabank.common.models.accounts.MoneyAmount
import com.maimabank.common.models.transactions.TransactionStatus
import com.maimabank.common.models.transactions.TransactionType

@Entity(tableName = "transactions")
@Keep
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val type: TransactionType,
    val value: MoneyAmount,
    val recentStatus: TransactionStatus,
    val cardId: String,
    val linkedContactId: Long? = null,
    val createdDate: Long,
    val updatedStatusDate: Long,
)
