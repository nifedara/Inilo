package com.inilo.domain.usecase.auth.remote

import com.inilo.data.auth.repository.RemoteAuthRepository
import com.inilo.data.util.Resource
import com.inilo.domain.util.UseCaseWithNoParam
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RemoteSignInUseCase @Inject constructor(
    private val repository: RemoteAuthRepository
): UseCaseWithNoParam<Resource<Any>> {

    override suspend fun invoke(): Flow<Resource<Any>> {
        return repository.signIn()
    }
}