package com.maimabank.di

import android.app.Application
import android.app.NotificationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotificationManager(application: Application): NotificationManager {
        return application.getSystemService(Application.NOTIFICATION_SERVICE) as NotificationManager
    }
}