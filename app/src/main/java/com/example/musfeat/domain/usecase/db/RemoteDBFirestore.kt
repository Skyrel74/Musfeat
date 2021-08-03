package com.example.musfeat.domain.usecase.db

import com.example.musfeat.domain.entities.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RemoteDBFirestore @Inject constructor(
    private val firestoreInstance: FirebaseFirestore,
    private val auth: FirebaseAuth
) : RemoteDB {

    private val currentUserDocRef: DocumentReference
        get() = firestoreInstance.document(
            "users/${
                auth.uid ?: throw NullPointerException(
                    "UID is null."
                )
            }"
        )

    override suspend fun createUser(user: User) {

    }
}