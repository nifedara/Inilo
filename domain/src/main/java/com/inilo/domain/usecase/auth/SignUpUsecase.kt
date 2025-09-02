package com.inilo.domain.usecase.auth

import com.inilo.data.auth.repository.FirebaseRepository
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import com.inilo.domain.util.UseCaseWithParam
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SignUpUseCase @Inject constructor(
    private val repository: FirebaseRepository
): UseCaseWithParam<FirebaseAuthRequest, FirebaseToken> {

    override suspend fun invoke(request: FirebaseAuthRequest): Flow<FirebaseToken> {
        return repository.signUp(authRequest = request)
    }
}