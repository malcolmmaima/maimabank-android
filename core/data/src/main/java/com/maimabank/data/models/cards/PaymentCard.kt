package com.maimabank.data.models.cards

import com.maimabank.common.models.accounts.MoneyAmount
import com.maimabank.database.entities.CardEntity

data class PaymentCard(
    val cardId: String,
    val isPrimary: Boolean,
    val cardNumber: String,
    val cardType: CardEntity.CardType,
    val cardHolder: String,
    val expiration: Long,
    val recentBalance: MoneyAmount,
    val addressFirstLine: String,
    val addressSecondLine: String,
    val addedDate: Long
)
