package com.maimabank.database.convertors

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.maimabank.common.models.accounts.BalanceCurrency
import com.maimabank.common.models.accounts.MoneyAmount

@ProvidedTypeConverter
class MoneyAmountConvertor {

    @TypeConverter
    fun moneyAmountToDb(value: MoneyAmount?): String? {
        return value?.let { "${it.value},${it.currency}" }
    }

    @TypeConverter
    fun moneyAmountFromDb(value: String?): MoneyAmount? {
        return value?.split(",")?.let {
            MoneyAmount(
                it[0].toFloat(),
                BalanceCurrency.valueOf(it[1])
            )
        }
    }
}
