package com.maimabank.networking.repository

import com.maimabank.features.networking.api.MaimaBankApiService
import com.maimabank.features.networking.util.BaseRepo
import javax.inject.Inject

class MaimaBankRepository @Inject constructor(
    private val apiService: MaimaBankApiService
) : BaseRepo() {

}







