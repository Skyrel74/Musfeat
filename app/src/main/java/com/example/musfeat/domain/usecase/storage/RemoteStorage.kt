package com.example.musfeat.domain.usecase.storage

import com.google.firebase.storage.StorageReference

interface RemoteStorage {

    /**
     * Function to upload [imageBytes] to storage
     */
    suspend fun uploadProfilePhoto(imageBytes: ByteArray)

    /**
     * Function to upload [imageBytes] to storage
     * [messageId] need to name file on storage
     * [onSuccess] function need to be called after successful execution
     */
    suspend fun uploadMessageImage(
        messageId: String,
        imageBytes: ByteArray,
        onSuccess: (imagePath: String) -> Unit
    )

    /**
     * Function to get reference to image from storage by its [path]
     */
    suspend fun pathToReference(path: String): StorageReference
}