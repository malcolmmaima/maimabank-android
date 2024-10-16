package com.maimabank.data.repository.otp

import com.maimabank.data.models.otp.OtpConfiguration
import com.maimabank.data.models.otp.OtpGenerationResponse
import com.maimabank.data.models.otp.OtpVerificationResponse

interface OtpRepository {
    suspend fun requestGenerateOtpCode(otpConfiguration: OtpConfiguration): OtpGenerationResponse

    suspend fun verifyOtpCode(
        otpConfiguration: OtpConfiguration,
        code: String
    ): OtpVerificationResponse
}
