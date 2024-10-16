package com.maimabank.data.repository.otp

import com.maimabank.data.models.otp.OtpConfiguration
import com.maimabank.data.models.otp.OtpGenerationResponse
import com.maimabank.data.models.otp.OtpVerificationResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

// Here we assuming that remote server receives request to generate OTP
// and binds it to certain session or specific operation (signup, pay and etc)
class OtpRepositoryMock(
    private val coroutineDispatcher: CoroutineDispatcher
) : OtpRepository {
    override suspend fun requestGenerateOtpCode(otpConfiguration: OtpConfiguration): OtpGenerationResponse =
        withContext(coroutineDispatcher) {
            return@withContext OtpGenerationResponse(
                remainingAttempts = 3
            )
        }

    override suspend fun verifyOtpCode(otpConfiguration: OtpConfiguration, code: String): OtpVerificationResponse =
        withContext(coroutineDispatcher) {
            delay(MOCK_DELAY)

            return@withContext if (code == MOCK_CODE) {
                OtpVerificationResponse(
                    isSuccess = true,
                    remainingAttempts = null
                )
            } else {
                OtpVerificationResponse(
                    isSuccess = false,
                    remainingAttempts = 3
                )
            }
        }

    companion object {
        private const val MOCK_DELAY = 1000L
        private const val MOCK_CODE = "1111"
    }
}
