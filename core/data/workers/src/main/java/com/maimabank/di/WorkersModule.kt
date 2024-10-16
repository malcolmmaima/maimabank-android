package com.maimabank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.work.WorkManager
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
import com.maimabank.database.dao.TransactionDao
import com.maimabank.repository.TransactionDatabaseRepositoryMock

@Module
@InstallIn(SingletonComponent::class)
object WorkersModule {

    @Provides
    @Singleton
    fun provideTransactionRepository(
        workManager: WorkManager,
        contactsRepository: ContactsRepository,
        transactionDao: TransactionDao
    ): com.maimabank.data.repository.transactions.TransactionRepository {
        return TransactionDatabaseRepositoryMock(
            workManager = workManager,
            contactsRepository = contactsRepository,
            transactionDao = transactionDao,
            coroutineDispatcher = Dispatchers.IO
        )
    }
}