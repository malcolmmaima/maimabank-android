package com.maimabank.utils.helpers.notification

import com.maimabank.common.models.accounts.BalanceCurrency
import com.maimabank.common.models.accounts.MoneyAmount
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

data class MoneyAmountUi(
    val amountStr: String,
) {
    companion object {
        fun mapFromDomain(balance: MoneyAmount): MoneyAmountUi {
            val symbols = DecimalFormatSymbols(Locale.US)
            val decimalFormat = DecimalFormat("#,##0.##", symbols)
            decimalFormat.isGroupingUsed = false
            val formattedValue = decimalFormat.format(balance.value)


            // Add currency prefixes
            return when (balance.currency) {
                BalanceCurrency.USD -> {
                    MoneyAmountUi("$$formattedValue")
                }
            }
        }
    }
}
