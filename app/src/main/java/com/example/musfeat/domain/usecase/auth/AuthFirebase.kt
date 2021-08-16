package com.example.musfeat.domain.usecase.auth

import com.example.musfeat.domain.entities.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthFirebase @Inject constructor(private val auth: FirebaseAuth) : Auth {

    override suspend fun signUp(
        email: String, password: String, user: User,
        onComplete: (user: User) -> Unit, onError: () -> Unit
    ): Unit = coroutineScope {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser!!.sendEmailVerification()
                    onComplete(user)
                } else
                    onError()
            }
    }

    override suspend fun signIn(
        email: String, password: String,
        onComplete: () -> Unit, onError: () -> Unit
    ): Unit = coroutineScope {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (auth.currentUser!!.isEmailVerified) {
//                        FirebaseMessaging.getInstance().token.addOnCompleteListener {
//                            FirestoreUtil.updateCurrentUser(registrationTokens = it.result)
//                            MyFirebaseMessagingService.addTokenToFirestore(it.result)
//                        }
                        onComplete()
                    } else {
                        launch { signOut() }
                        onError()
                    }
                } else
                    onError()
            }
    }

    override suspend fun signOut() = auth.signOut()
}