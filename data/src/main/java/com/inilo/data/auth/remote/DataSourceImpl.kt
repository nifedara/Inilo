package com.inilo.data.auth.remote

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import com.inilo.data.pref.PreferenceStorageImpl
import com.inilo.data.remote.ApiService
import com.inilo.data.util.Resource
import com.inilo.data.util.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DataSourceImpl @Inject constructor(
    val apiService: ApiService,
    private val dataStore: PreferenceStorageImpl,
): FirebaseDataSource, RemoteAuthDataSource {
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
                        if (task.exception is FirebaseAuthUserCollisionException) {
                            auth.signInWithEmailAndPassword(authRequest.email, authRequest.password)
                                .addOnCompleteListener { signInTask ->
                                    cont.resume(if (signInTask.isSuccessful) auth.currentUser else null)
                                }
                        } else {
                            cont.resume(null)
                        }
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
                dataStore.saveToken(token)
                Log.v("token from datasource", token)
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
                dataStore.saveToken(token)
                Log.v("token from datasource", token)
            }
        }
    }

    override suspend fun signUp(): Flow<Resource<Any>> = flow {

        val result = safeApiCall { apiService.signup() }

        if (result.isError()){
            emit(Resource.error(result.message))
        }else{
            if(!result.isSuccess()){
                emit(Resource.error(result.message))
            }else{
                emit(Resource.success(result.message))
            }

        }
    }

    override suspend fun signIn(): Flow<Resource<Any>> = flow {

        val result = safeApiCall { apiService.signin() }

        if (result.isError()){
            emit(Resource.error(result.message))
        }else{
            if(!result.isSuccess()){
                emit(Resource.error(result.message))
            }else{
                emit(Resource.success(result.message))
            }

        }
    }
}