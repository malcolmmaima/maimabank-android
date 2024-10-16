package com.maimabank.data.repository.login

interface LoginRepository {
    suspend fun loginWithEmail(email: String, password: String)
    suspend fun checkIfLoggedIn(): Boolean
    suspend fun logOut()
}
