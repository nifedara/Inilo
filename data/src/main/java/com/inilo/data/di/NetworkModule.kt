package com.inilo.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.inilo.data.BuildConfig
import com.inilo.data.remote.ApiService
import com.inilo.data.util.AuthHeaderInterceptor
import com.inilo.data.util.CommonHeaderInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    val Context.dataStore by preferencesDataStore(name = "IniloDataStore")

    @Provides
    @Singleton
    fun providesDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }

    @Singleton
    @Provides
    @Named("logging")
    internal fun provideHttpLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideHttpClient(
        authHeaderInterceptor: AuthHeaderInterceptor,
        @Named("logging") httpLoggingInterceptor: Interceptor
    ): OkHttpClient {
        return createOkHttpClient(authHeaderInterceptor, httpLoggingInterceptor)
    }

    private fun createOkHttpClient(
        authHeaderInterceptor: AuthHeaderInterceptor,
        logging: Interceptor
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(authHeaderInterceptor)
            .addInterceptor(logging)
            .protocols(arrayListOf(Protocol.HTTP_1_1))
            .build()
    }

    @Provides
    @Singleton
    @Named("header")
    fun provideCommonHeaderInterceptor(): Interceptor {
        return CommonHeaderInterceptor()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideRetroFit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Singleton
    @Provides
    fun provideKeysApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}