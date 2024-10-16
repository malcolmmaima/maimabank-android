package com.maimabank.utils.extensions

fun formatCurrency(currencySymbol: String, price: Double): String {
    val priceString = price.toString().removeSuffix(".0")
    return "$currencySymbol$priceString"
}

fun String.splitStringWithDivider(
    groupCharCount: Int = 4,
    divider: Char = ' '
): String {
    val formattedStringBuilder = StringBuilder()
    var count = 0

    for (char in this) {
        if (count > 0 && count % groupCharCount == 0) {
            formattedStringBuilder.append(divider)
        }
        formattedStringBuilder.append(char)
        count++
    }

    return formattedStringBuilder.toString()
}

fun String.maskCardId(visibleCharacters: Int = 4): String {
    return "*" + substring(length - visibleCharacters)
}
