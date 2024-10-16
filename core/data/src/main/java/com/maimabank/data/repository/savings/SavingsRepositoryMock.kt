package com.maimabank.data.repository.savings

import android.content.Context
import com.maimabank.data.models.savings.Saving
import com.maimabank.data.repository.cards.CardsRepository
import com.maimabank.utils.helpers.errors.AppError
import com.maimabank.utils.helpers.errors.ErrorType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SavingsRepositoryMock(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val context: Context,
    private val cardsRepository: CardsRepository
) : SavingsRepository {
    override suspend fun getSavings(): List<Saving> = withContext(coroutineDispatcher) {
        // Mock value
        val mockLinkedCard = cardsRepository.getCards().firstOrNull()?.cardNumber

        return@withContext listOf(
            Saving(
                id = 0L,
                title = "Buy Playstation",
                description = "Slim 1 TB 56 Games",
                completedPercentage = 0.7f,
                iconUrl = getMockImageUrl("ic_playstation"),
                linkedCardId = mockLinkedCard
            ),
            Saving(
                id = 1L,
                title = "Buy Car Remote",
                description = "Mercedez Benz 001",
                completedPercentage = 0.8f,
                iconUrl = getMockImageUrl("ic_car"),
                linkedCardId = mockLinkedCard
            ),
            Saving(
                id = 2L,
                title = "Buy Bicycle",
                description = "Mountain bike R7",
                completedPercentage = 0.6f,
                iconUrl = getMockImageUrl("ic_bike"),
                linkedCardId = mockLinkedCard
            ),
            Saving(
                id = 3L,
                title = "Buy Mini Vespa",
                description = "Mini Vespa Scooter 6v",
                completedPercentage = 1f,
                iconUrl = getMockImageUrl("ic_scooter"),
                linkedCardId = mockLinkedCard
            ),
            Saving(
                id = 4L,
                title = "Buy Barbie Doll",
                description = "One Set Purple",
                completedPercentage = 1f,
                iconUrl = getMockImageUrl("ic_doll"),
                linkedCardId = null
            )
        )
    }

    override suspend fun getSavingById(id: Long): Saving {
        return this.getSavings().find {
            it.id == id
        } ?: throw AppError(ErrorType.GENERIC_NOT_FOUND_ERROR)
    }

    private fun getMockImageUrl(
        drawableName: String
    ): String {
        val packageName = context.packageName
        return "android.resource://$packageName/drawable/$drawableName"
    }
}
