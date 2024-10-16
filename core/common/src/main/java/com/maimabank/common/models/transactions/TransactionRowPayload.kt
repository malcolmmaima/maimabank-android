package com.maimabank.common.models.transactions

import com.maimabank.common.models.accounts.MoneyAmount

data class TransactionRowPayload(
    val type: TransactionType,
    val amount: MoneyAmount,
    val cardId: String,
    val contactId: Long? = null,
)