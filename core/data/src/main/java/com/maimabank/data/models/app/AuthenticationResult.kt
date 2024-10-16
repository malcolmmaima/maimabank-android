package com.maimabank.data.models.app

sealed class AuthenticationResult {
    object Success : AuthenticationResult()

    data class Failure(
        val remainingAttempts: Int?
    ) : AuthenticationResult()
}
