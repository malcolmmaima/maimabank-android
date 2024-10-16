package com.maimabank.data.repository.signup

import com.maimabank.data.models.otp.OtpConfiguration
import com.maimabank.data.models.otp.OtpVerificationResponse
import com.maimabank.data.models.signup.SignUpPayload

interface SignUpRepository {
    suspend fun signUpWithEmail(payload: SignUpPayload)

    suspend fun confirmSignUpWithEmail(
        otpCode: String,
        otpConfiguration: OtpConfiguration
    ): OtpVerificationResponse
}