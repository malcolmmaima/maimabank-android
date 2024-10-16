package com.maimabank

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.maimabank.utils.R
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MaimaBankingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        setupNotifications()
    }

    private fun setupNotifications() {
        // Create notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = getString(R.string.TRANSACTIONS_NOTIFICATION_CHANNEL_NAME)
            val id = getString(R.string.TRANSACTIONS_NOTIFICATION_CHANNEL_ID)

            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance)
            channel.setSound(null, null)

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
