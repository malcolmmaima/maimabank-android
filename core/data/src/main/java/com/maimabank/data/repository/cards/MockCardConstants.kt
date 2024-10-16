package com.maimabank.data.repository.cards

import com.maimabank.data.models.cards.CardType
import com.maimabank.database.entities.CardEntity

object MockCardConstants {
    // https://github.com/drmonkeyninja/test-payment-cards/blob/master/readme.md
    private val cards: Map<String, CardEntity.CardType> = mapOf(
        // Mastercard
        "2298126833989874" to CardEntity.CardType.CREDIT,
        "5555555555554444" to CardEntity.CardType.DEBIT,
        // VISA
        "4111111111111111" to CardEntity.CardType.DEBIT,
        // Maestro
        "6304000000000000" to CardEntity.CardType.DEBIT
    )

    fun randomCard(): Pair<String, CardEntity.CardType> {
        return cards.toList().random()
    }

    fun cardTypeByNumber(cardNumber: String): CardEntity.CardType? {
        return cards[cardNumber]
    }
}