package com.maimabank.utils.extensions

inline fun <T> Iterable<T>.sumFloat(selector: (T) -> Float): Float {
    var sum = 0F
    for (element in this) {
        sum += selector(element)
    }
    return sum
}
