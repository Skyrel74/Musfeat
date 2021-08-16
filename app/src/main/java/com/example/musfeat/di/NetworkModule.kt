package com.example.musfeat.di

import com.example.musfeat.domain.usecase.auth.Auth
import com.example.musfeat.domain.usecase.auth.AuthFirebase
import com.example.musfeat.domain.usecase.db.RemoteDB
import com.example.musfeat.domain.usecase.db.RemoteDBFirestore
import com.example.musfeat.domain.usecase.storage.RemoteStorage
import com.example.musfeat.domain.usecase.storage.RemoteStorageImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideAuthInstance(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuth(auth: FirebaseAuth): Auth = AuthFirebase(auth)

    @Provides
    @Singleton
    fun provideRemoteDBInstance(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideRemoteDB(firestore: FirebaseFirestore, auth: FirebaseAuth): RemoteDB =
        RemoteDBFirestore(firestore, auth)

    @Provides
    @Singleton
    fun provideStorageInstance(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideCurrentUserRef(storage: FirebaseStorage, auth: FirebaseAuth): StorageReference =
        storage.reference
            .child("users/${auth.currentUser!!.uid}")

    @Provides
    @Singleton
    fun provideStorage(
        storage: FirebaseStorage,
        storageReference: StorageReference
    ): RemoteStorage =
        RemoteStorageImpl(storage, storageReference)
}