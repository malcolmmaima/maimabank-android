package com.maimabank.data.repository.profile

import com.maimabank.data.models.profile.CompactProfile

interface ProfileRepository {
    suspend fun getCompactProfile(): CompactProfile
}
