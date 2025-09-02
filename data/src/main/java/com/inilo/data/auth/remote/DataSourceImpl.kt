package com.inilo.data.auth.remote

import com.google.firebase.auth.FirebaseAuth
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DataSourceImpl @Inject constructor(): FirebaseDataSource {
    val auth = FirebaseAuth.getInstance()

    override suspend fun signUp(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> = flow {

        val user = suspendCoroutine { cont ->
            auth.createUserWithEmailAndPassword(authRequest.email, authRequest.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        cont.resume(auth.currentUser)
                    } else {
                        cont.resume(null)
                    }
                }
        }
        if (user != null) {
            val token = suspendCoroutine { cont ->
                user.getIdToken(true)
                    .addOnSuccessListener { result -> cont.resume(result.token) }
                    .addOnFailureListener { cont.resume(null) }
            }

            if (token != null) {
                emit(FirebaseToken(token))
            }
        }
    }

    override suspend fun signIn(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> = flow {

        val user = suspendCoroutine { cont ->
            auth.signInWithEmailAndPassword(authRequest.email, authRequest.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        cont.resume(auth.currentUser)
                    } else {
                        cont.resume(null)
                    }
                }
        }
        if (user != null) {
            val token = suspendCoroutine { cont ->
                user.getIdToken(true)
                    .addOnSuccessListener { result -> cont.resume(result.token) }
                    .addOnFailureListener { cont.resume(null) }
            }

            if (token != null) {
                emit(FirebaseToken(token))
            }
        }
    }
}