package com.maimabank.di

import androidx.work.WorkManager
import com.maimabank.data.repository.contacts.ContactsRepository
import com.maimabank.database.dao.TransactionDao
import com.maimabank.repository.TransactionDatabaseRepositoryMock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers

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
