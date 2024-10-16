package com.maimabank.data.repository.transactions

import androidx.paging.PagingData
import com.maimabank.common.models.transactions.Transaction
import com.maimabank.common.models.transactions.TransactionRowPayload
import com.maimabank.common.models.transactions.TransactionStatus
import com.maimabank.common.models.transactions.TransactionType
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    suspend fun getTransactions(filterByType: TransactionType?): Flow<PagingData<Transaction>>
    fun getTransactionStatusFlow(transactionId: Long): Flow<TransactionStatus>
    suspend fun submitTransaction(payload: TransactionRowPayload)
}