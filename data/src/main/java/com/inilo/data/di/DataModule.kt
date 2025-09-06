package com.inilo.data.di

import com.inilo.data.auth.remote.DataSourceImpl
import com.inilo.data.auth.remote.FirebaseDataSource
import com.inilo.data.auth.remote.RemoteAuthDataSource
import com.inilo.data.auth.repository.AuthRepositoryImpl
import com.inilo.data.auth.repository.FirebaseRepository
import com.inilo.data.auth.repository.RemoteAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    @Singleton
    abstract fun bindFirebaseDataSource(firebaseDataSource: DataSourceImpl): FirebaseDataSource

    @Binds
    @Singleton
    abstract fun bindFirebaseRepository(firebaseRepository: AuthRepositoryImpl): FirebaseRepository

    @Binds
    @Singleton
    abstract fun bindRemoteAuthDataSource(remoteAuthDataSource: DataSourceImpl): RemoteAuthDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteAuthRepository(remoteAuthRepository: AuthRepositoryImpl): RemoteAuthRepository
}