package com.maimabank.data.models.otp

data class OtpConfiguration(
    val operationType: OtpOperationType,
    val otpType: OtpType,
    val otpDestination: String
)
