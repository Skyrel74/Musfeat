package com.example.musfeat.domain.usecase.auth

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class AuthFirebase @Inject constructor(private val auth: FirebaseAuth) : Auth {

    override suspend fun signUp(email: String, password: String): Unit = coroutineScope {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser!!.sendEmailVerification()

                } else {
                    // TODO("Обработка ошибки создания аккаунта и отображение для пользователя")
                }
            }
    }

    override suspend fun signIn(email: String, password: String) {
//        firebaseAuthInstance.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val isEmailVerified: Boolean =
//                        firebaseAuthInstance.currentUser?.isEmailVerified ?: false
//                    if (isEmailVerified) {
//                        FirebaseMessaging.getInstance().token.addOnCompleteListener {
//                            FirestoreUtil.updateCurrentUser(registrationTokens = it.result)
//                            MyFirebaseMessagingService.addTokenToFirestore(it.result)
//                            Log.d("FCM", it.result.toString())
//                        }
//                        viewState.toSwipeFragment()
//                    } else {
//                        FirebaseAuth.getInstance().signOut()
//                        viewState.showError("Подтвердите email")
//                    }
//                }
//            }
    }

    override suspend fun signOut() = auth.signOut()
}