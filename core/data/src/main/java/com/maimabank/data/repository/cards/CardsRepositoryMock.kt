package com.maimabank.data.repository.cards

import com.maimabank.common.models.accounts.MoneyAmount
import com.maimabank.data.models.cards.AddCardPayload
import com.maimabank.data.models.cards.PaymentCard
import com.maimabank.database.dao.CardsDao
import com.maimabank.database.entities.CardEntity
import com.maimabank.utils.helpers.errors.AppError
import com.maimabank.utils.helpers.errors.ErrorType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class CardsRepositoryMock(
    private val cardsDao: CardsDao,
    private val coroutineDispatcher: CoroutineDispatcher
) : CardsRepository {
    override suspend fun getCards(): List<PaymentCard> = withContext(coroutineDispatcher) {
        delay(MOCK_DELAY)

        return@withContext cardsDao.getCards().map { cardEntity ->
            mapCachedCardToDomain(cardEntity)
        }
    }

    override suspend fun addCard(data: AddCardPayload) = withContext(coroutineDispatcher) {
        val card = cardsDao.getCardByNumber(data.cardNumber)

        if (card == null) {
            delay(MOCK_DELAY)

            val entity = mapAddCardPayloadToCache(data)
            cardsDao.addCard(entity)
        }
        else {
            throw AppError(ErrorType.CARD_ALREADY_ADDED)
        }
    }

    override suspend fun getCardById(id: String): PaymentCard = withContext(coroutineDispatcher) {
        val cardEntity = cardsDao.getCardByNumber(id) ?: throw AppError(ErrorType.CARD_NOT_FOUND)
        delay(MOCK_DELAY)
        return@withContext mapCachedCardToDomain(cardEntity)
    }

    private fun mapCachedCardToDomain(cardEntity: CardEntity) = PaymentCard(
        cardId = cardEntity.number,
        cardNumber = cardEntity.number,
        isPrimary = cardEntity.isPrimary,
        cardHolder = cardEntity.cardHolder,
        addressFirstLine = cardEntity.addressFirstLine,
        addressSecondLine = cardEntity.addressSecondLine,
        expiration = cardEntity.expiration,
        addedDate = cardEntity.addedDate,
        recentBalance = MoneyAmount(cardEntity.recentBalance),
        cacheCardType = cardEntity.cacheCardType
    )

    private fun mapAddCardPayloadToCache(addCardPayload: AddCardPayload): CardEntity {
        val type = MockCardConstants.cardTypeByNumber(addCardPayload.cardNumber) ?: CardEntity.CacheCardType.DEBIT

        return CardEntity(
            number = addCardPayload.cardNumber,
            isPrimary = false,
            cardHolder = addCardPayload.cardHolder,
            addressFirstLine = addCardPayload.addressFirstLine,
            addressSecondLine = addCardPayload.addressSecondLine,
            expiration = addCardPayload.expirationDate,
            addedDate = System.currentTimeMillis(),
            recentBalance = MOCK_CARD_INITIAL_BALANCE,
            cacheCardType = type
        )
    }

    override suspend fun deleteCardById(id: String) {
        val cardEntity = cardsDao.getCardByNumber(id) ?: throw AppError(ErrorType.CARD_NOT_FOUND)
        delay(MOCK_DELAY)
        cardsDao.deleteCard(cardEntity)
    }

    override suspend fun markCardAsPrimary(cardId: String, isPrimary: Boolean) {
        when (isPrimary) {
            true ->  cardsDao.markCardAsPrimary(cardId)
            false -> cardsDao.unmarkCardAsPrimary(cardId)
        }
    }

    companion object {
        private const val MOCK_DELAY = 500L
        private const val MOCK_CARD_INITIAL_BALANCE = 0f
    }
}