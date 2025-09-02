package com.inilo.data.auth.remote

import com.google.firebase.auth.FirebaseAuth
import com.inilo.data.model.FirebaseAuthRequest
import com.inilo.data.model.FirebaseToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataSourceImpl @Inject constructor(): FirebaseDataSource {
    val auth = FirebaseAuth.getInstance()

    override suspend fun signUp(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> = flow {
        auth.createUserWithEmailAndPassword(authRequest.email, authRequest.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser?.getIdToken(true)
                        ?.addOnSuccessListener { result ->
                            result
                        }
                        ?.addOnFailureListener {  }
                } else {

                }
            }
    }

    override suspend fun signIn(
        authRequest: FirebaseAuthRequest
    ): Flow<FirebaseToken> = flow {
        auth.signInWithEmailAndPassword(authRequest.email, authRequest.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser?.getIdToken(true)
                        ?.addOnSuccessListener { result ->
                            result
                        }
                        ?.addOnFailureListener {  }
                } else {

                }
            }
    }
}