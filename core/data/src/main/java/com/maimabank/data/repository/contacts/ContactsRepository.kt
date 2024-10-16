package com.maimabank.data.repository.contacts

import com.maimabank.common.models.contacts.Contact

interface ContactsRepository {
    suspend fun getContacts(): List<Contact>

    suspend fun getContactById(contactId: Long): Contact

    suspend fun getContactFromQr(qrCode: String): Contact
}