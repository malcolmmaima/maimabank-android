package com.maimabank.data.repository.users

import com.maimabank.database.dao.UserDao
import com.maimabank.database.entities.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun addUser(username: String, email: String, password: String, phoneNumber: String?) {
        val user = UserEntity(
            username = username,
            email = email,
            password = password,
            phoneNumber = phoneNumber,
            createdAt = System.currentTimeMillis(),
            updatedAt = null
        )
        userDao.insertUser(user)
    }

    suspend fun getUserById(userId: Long): UserEntity? {
        return userDao.getUserById(userId)
    }

    // Update user details
    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    // Delete a user
    suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }

    // Delete all users
    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }
}
