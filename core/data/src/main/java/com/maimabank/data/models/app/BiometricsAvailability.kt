package com.maimabank.data.models.app

sealed class BiometricsAvailability {
    object Checking : BiometricsAvailability()
    object Available : BiometricsAvailability()
    object NotAvailable : BiometricsAvailability()
    object NotEnabled : BiometricsAvailability()
}
