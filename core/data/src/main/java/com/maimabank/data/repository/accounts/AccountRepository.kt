package com.maimabank.data.repository.accounts

import com.maimabank.common.models.accounts.MoneyAmount
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getBalanceFlow(): Flow<MoneyAmount>
    suspend fun getCardBalanceFlow(cardId: String): Flow<MoneyAmount>
    suspend fun topUpCard(cardId: String, amount: MoneyAmount)
    suspend fun sendFromCard(cardId: String, amount: MoneyAmount, contactId: Long)
}