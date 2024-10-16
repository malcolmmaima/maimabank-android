package com.maimabank.data.di

import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.cioccarellia.ksprefs.KsPrefs
import com.maimabank.data.repository.accounts.AccountRepository
import com.maimabank.data.repository.accounts.AccountRepositoryMock
import com.maimabank.data.repository.app.AppLockRepository
import com.maimabank.data.repository.app.AppLockRepositoryImpl
import com.maimabank.data.repository.app.AppRepositoryImpl
import com.maimabank.data.repository.app.AppSettignsRepository
import com.maimabank.data.repository.cards.CardsRepository
import com.maimabank.data.repository.cards.CardsRepositoryMock
import com.maimabank.data.repository.contacts.ContactsRepository
import com.maimabank.data.repository.login.LoginRepository
import com.maimabank.data.repository.login.LoginRepositoryMock
import com.maimabank.data.repository.otp.OtpRepository
import com.maimabank.data.repository.otp.OtpRepositoryMock
import com.maimabank.data.repository.profile.ProfileRepository
import com.maimabank.data.repository.profile.ProfileRepositoryMock
import com.maimabank.data.repository.savings.SavingsRepository
import com.maimabank.data.repository.savings.SavingsRepositoryMock
import com.maimabank.data.repository.signup.SignUpRepository
import com.maimabank.data.repository.signup.SignUpRepositoryMock
import com.maimabank.database.dao.CardsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideAppSettingsRepository(
        appRepositoryImpl: AppRepositoryImpl
    ): AppSettignsRepository {
        return appRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideKsPrefs(application: Application): KsPrefs {
        return KsPrefs(application.applicationContext)
    }

    @Provides
    @Singleton
    fun provideSignUpRepository(
        otpRepository: OtpRepository,
        prefs: KsPrefs
    ): SignUpRepository {
        return SignUpRepositoryMock(
            coroutineDispatcher = Dispatchers.IO,
            otpRepository = otpRepository,
            prefs = prefs
        )
    }

    @Provides
    @Singleton
    fun provideLoginRepository(
        prefs: KsPrefs,
        securedPrefs: EncryptedSharedPreferences
    ): LoginRepository {
        return LoginRepositoryMock(
            coroutineDispatcher = Dispatchers.IO,
            prefs = prefs,
            securedPrefs = securedPrefs
        )
    }

    @Provides
    @Singleton
    fun provideProfileRepository(): ProfileRepository {
        return ProfileRepositoryMock(dispatcher = Dispatchers.IO)
    }

    @Provides
    @Singleton
    fun provideCardsRepository(cardsDao: CardsDao): CardsRepository {
        return CardsRepositoryMock(
            cardsDao = cardsDao,
            coroutineDispatcher = Dispatchers.IO
        )
    }

    @Provides
    @Singleton
    fun provideSavingsRepository(
        cardsRepository: CardsRepository,
        application: Application
    ): SavingsRepository {
        return SavingsRepositoryMock(
            coroutineDispatcher = Dispatchers.IO,
            context = application.applicationContext,
            cardsRepository = cardsRepository
        )
    }

    @Provides
    @Singleton
    fun provideOtpRepository(): OtpRepository {
        return OtpRepositoryMock(
            coroutineDispatcher = Dispatchers.IO
        )
    }

    @Provides
    @Singleton
    fun provideEncryptedSharedPreferences(
        application: Application
    ): SharedPreferences {
        val context = application.applicationContext

        val masterKey: MasterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return EncryptedSharedPreferences.create(
            context,
            "secured_shared_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    @Provides
    @Singleton
    fun provideAppLockRepository(
        securedPreferences: EncryptedSharedPreferences,
        application: Application
    ): AppLockRepository {
        return AppLockRepositoryImpl(
            securedPreferences = securedPreferences,
            context = application.applicationContext
        )
    }

    @Provides
    @Singleton
    fun provideAccountRepository(cardsDao: CardsDao): AccountRepository {
        return AccountRepositoryMock(
            coroutineDispatcher = Dispatchers.IO,
            cardsDao = cardsDao
        )
    }

    @Provides
    @Singleton
    fun provideContactsRepository(): ContactsRepository {
        return com.maimabank.data.repository.contacts.ContactsDatabaseRepositoryMock()
    }
}
