package com.example.musfeat.presentation.signUpPersonalization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musfeat.domain.entities.User
import com.example.musfeat.domain.usecase.auth.Auth
import com.example.musfeat.domain.usecase.db.RemoteDB
import com.example.musfeat.domain.usecase.storage.RemoteStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpPersonalizationViewModel @Inject constructor(
    private val auth: Auth,
    private val remoteDB: RemoteDB,
    private val remoteStorage: RemoteStorage,
) : ViewModel() {

    suspend fun signUp(
        email: String,
        password: String,
        onError: () -> Unit,
        user: User,
        imageBytes: ByteArray?
    ) {
        viewModelScope.launch {
            auth.signUp(email, password, user, {
                remoteDB.createUser(user) {
                    if (imageBytes != null)
                        remoteStorage.uploadProfilePhoto(imageBytes)
                }
            }, {
                onError()
            })
        }
    }
}