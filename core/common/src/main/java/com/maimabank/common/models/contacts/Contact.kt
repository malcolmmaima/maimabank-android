package com.maimabank.common.models.contacts

data class Contact(
    val id: Long,
    val name: String,
    val profilePic: String,
    val linkedCardNumber: String
)
