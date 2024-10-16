package com.maimabank.data.models.otp

data class OtpVerificationResponse(
    val isSuccess: Boolean,
    val remainingAttempts: Int?
)
