package com.maimabank.data.repository.login

import android.content.SharedPreferences
import com.cioccarellia.ksprefs.KsPrefs
import com.maimabank.data.repository.app.PrefKeys
import com.maimabank.utils.helpers.errors.AppError
import com.maimabank.utils.helpers.errors.ErrorType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class LoginRepositoryMock(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val prefs: KsPrefs,
    private val securedPrefs: SharedPreferences
) : LoginRepository {

    override suspend fun loginWithEmail(email: String, password: String) = withContext(
        coroutineDispatcher
    ) {
        delay(MOCK_DELAY)

        // TODO login attempts
        if (email == MOCK_LOGIN_EMAIL && password == MOCK_PASSWORD) {
            prefs.push(PrefKeys.IS_LOGGED_IN.name, true)
            return@withContext
        } else if (email != MOCK_LOGIN_EMAIL) {
            throw AppError(ErrorType.USER_NOT_FOUND)
        } else {
            throw AppError(ErrorType.WRONG_PASSWORD)
        }
    }

    override suspend fun checkIfLoggedIn(): Boolean {
        delay(MOCK_DELAY)
        return prefs.pull(PrefKeys.IS_LOGGED_IN.name, false)
    }

    override suspend fun logOut() = withContext(coroutineDispatcher) {
        // here may be some logic like cleanup and logout api call
        delay(MOCK_DELAY)

        // Clear app settings
        prefs.push(PrefKeys.IS_LOGGED_IN.name, false)

        // Clear encrypted storage
        securedPrefs.edit().clear().apply()
    }

    companion object {
        private const val MOCK_LOGIN_EMAIL = "example@mail.com"
        private const val MOCK_PASSWORD = "1234567Ab"
        private const val MOCK_DELAY = 1000L
    }
}
