package com.maimabank.data.repository.cards

import com.maimabank.data.models.cards.AddCardPayload
import com.maimabank.data.models.cards.PaymentCard

interface CardsRepository {
    suspend fun getCards(): List<PaymentCard>
    suspend fun addCard(data: AddCardPayload)
    suspend fun getCardById(id: String): PaymentCard
    suspend fun deleteCardById(id: String)
    suspend fun markCardAsPrimary(cardId: String, isPrimary: Boolean = false)
}