package com.maimabank.data.repository.savings

import com.maimabank.data.models.savings.Saving

interface SavingsRepository {
    suspend fun getSavings(): List<Saving>
    suspend fun getSavingById(id: Long): Saving
}