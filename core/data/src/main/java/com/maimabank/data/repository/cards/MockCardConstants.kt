package com.maimabank.data.repository.cards

import com.maimabank.database.entities.CardEntity

object MockCardConstants {
    // https://github.com/drmonkeyninja/test-payment-cards/blob/master/readme.md
    private val cards: Map<String, CardEntity.CacheCardType> = mapOf(
        // Mastercard
        "2298126833989874" to CardEntity.CacheCardType.CREDIT,
        "5555555555554444" to CardEntity.CacheCardType.DEBIT,
        // VISA
        "4111111111111111" to CardEntity.CacheCardType.DEBIT,
        // Maestro
        "6304000000000000" to CardEntity.CacheCardType.DEBIT
    )

    fun randomCard(): Pair<String, CardEntity.CacheCardType> {
        return cards.toList().random()
    }

    fun cardTypeByNumber(cardNumber: String): CardEntity.CacheCardType? {
        return cards[cardNumber]
    }
}