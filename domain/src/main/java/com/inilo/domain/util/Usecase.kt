package com.inilo.domain.util

import kotlinx.coroutines.flow.Flow


interface UseCaseWithParam<in P,out T> {

    suspend operator fun invoke(request: P): Flow<T>
}

interface UseCaseWithNoParam<out T> {

    suspend operator fun invoke(): Flow<T>
}
