package com.example.musfeat.domain.usecase.storage

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import javax.inject.Inject

class RemoteStorageImpl @Inject constructor(
    private val storage: FirebaseStorage,
    private val currentUserRef: StorageReference
) : RemoteStorage {

    override suspend fun uploadProfilePhoto(
        imageBytes: ByteArray,
        onSuccess: (imagePath: String) -> Unit
    ) {
        val profPictRef = currentUserRef.child("profilePicture")
        profPictRef.putBytes(imageBytes).addOnSuccessListener {
            onSuccess(profPictRef.path)
        }
    }

    override suspend fun uploadMessageImage(
        messageId: String,
        imageBytes: ByteArray,
        onSuccess: (imagePath: String) -> Unit
    ) {
        val messagesPictRef = storage.reference.child("messages/$messageId")
        messagesPictRef.putBytes(imageBytes).addOnSuccessListener {
            onSuccess(messagesPictRef.path)
        }
    }

    override suspend fun pathToReference(path: String): StorageReference =
        storage.getReference(path)
}