package com.maimabank.common.models.transactions

import com.maimabank.common.models.accounts.MoneyAmount
import com.maimabank.common.models.contacts.Contact

data class Transaction(
    val id: Long,
    val type: TransactionType,
    val value: MoneyAmount,
    val linkedContact: Contact?,
    val recentStatus: TransactionStatus,
    val createdDate: Long,
    val updatedStatusDate: Long
)
