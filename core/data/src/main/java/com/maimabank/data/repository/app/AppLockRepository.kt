package com.maimabank.data.repository.app

import com.maimabank.data.models.app.AuthenticationResult
import com.maimabank.data.models.app.BiometricsAvailability

interface AppLockRepository {
    fun setupAppLock(pinCode: String)
    fun authenticateWithPin(pin: String): AuthenticationResult
    fun checkIfAppLocked(): Boolean
    fun checkBiometricsAvailable(): BiometricsAvailability
    fun setupLockWithBiometrics(isLocked: Boolean)
    fun checkIfAppLockedWithBiometrics(): Boolean
}
