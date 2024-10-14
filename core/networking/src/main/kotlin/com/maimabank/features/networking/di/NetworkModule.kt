package com.maimabank.features.networking.di

import com.maimabank.features.networking.api.MaimaBankApiService
import com.maimabank.features.networking.repository.MaimaBankRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://http://localhost:8080/"

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun providesOkhttp(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMaimaBankApiService(retrofit: Retrofit): MaimaBankApiService {
        return retrofit.create(MaimaBankApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMaimaBankRepository(apiService: MaimaBankApiService): MaimaBankRepository {
        return MaimaBankRepository(apiService)
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IODispatcher