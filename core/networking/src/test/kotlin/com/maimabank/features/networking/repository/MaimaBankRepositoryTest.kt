package com.maimabank.features.networking.repository

import com.maimabank.features.networking.api.MaimaBankApiService
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before

@ExperimentalCoroutinesApi
class MaimaBankRepositoryTest {

    private lateinit var apiService: MaimaBankApiService
    private lateinit var maimaBankRepository: MaimaBankRepository

    @Before
    fun setUp() {
        apiService = mockk()
        maimaBankRepository = MaimaBankRepository(apiService)
    }
}






