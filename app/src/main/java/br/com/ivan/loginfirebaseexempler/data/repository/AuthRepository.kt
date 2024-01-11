package br.com.ivan.loginfirebaseexempler.data.repository

import android.net.Uri
import br.com.ivan.loginfirebaseexempler.model.User
import br.com.ivan.loginfirebaseexempler.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(email: String, password: String): Flow<NetworkResult<Boolean>>

    suspend fun signUp(user: User, password: String): Flow<NetworkResult<User>>

    suspend fun logOut(): Flow<NetworkResult<Boolean>>

    suspend fun saveUser(user: User, uri: Uri): Flow<NetworkResult<Boolean>>

    suspend fun getUserData(): Flow<NetworkResult<User>>
}