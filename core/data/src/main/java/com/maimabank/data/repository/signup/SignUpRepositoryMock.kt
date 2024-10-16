package com.maimabank.data.repository.signup

import com.cioccarellia.ksprefs.KsPrefs
import com.maimabank.data.models.otp.OtpConfiguration
import com.maimabank.data.models.otp.OtpVerificationResponse
import com.maimabank.data.models.signup.SignUpPayload
import com.maimabank.data.repository.app.PrefKeys
import com.maimabank.data.repository.otp.OtpRepository
import com.maimabank.networking.util.OperationResult
import com.maimabank.utils.helpers.errors.AppError
import com.maimabank.utils.helpers.errors.ErrorType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class SignUpRepositoryMock(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val otpRepository: OtpRepository,
    private val prefs: KsPrefs
) : SignUpRepository {
    override suspend fun signUpWithEmail(payload: SignUpPayload) = withContext(coroutineDispatcher) {
        delay(MOCK_DELAY)

        if (payload.email == MOCK_LOGIN_EMAIL && payload.password == MOCK_PASSWORD) {
            return@withContext
        } else {
            throw AppError(ErrorType.UNKNOWN_ERROR)
        }
    }

    override suspend fun confirmSignUpWithEmail(
        otpCode: String,
        otpConfiguration: OtpConfiguration
    ): OtpVerificationResponse = withContext(coroutineDispatcher) {
        delay(MOCK_DELAY)

        val signUpResult = OperationResult.runWrapped {
            otpRepository.verifyOtpCode(
                otpConfiguration = otpConfiguration,
                code = otpCode
            )
        }

        when (signUpResult) {
            is OperationResult.Success -> {
                // Successful signup
                if (signUpResult.data.isSuccess) {
                    prefs.push(PrefKeys.IS_LOGGED_IN.name, true)
                }

                return@withContext signUpResult.data
            }

            is OperationResult.Failure -> {
                throw signUpResult.error
            }
        }
    }

    companion object {
        private const val MOCK_LOGIN_EMAIL = "example@mail.com"
        private const val MOCK_PASSWORD = "1234567Ab"
        private const val MOCK_DELAY = 1000L
    }
}
