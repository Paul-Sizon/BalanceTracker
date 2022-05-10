package com.balance.tracker.auth.api

import com.balance.tracker.auth.domain.AuthResult
import com.balance.tracker.data.db.UserInfo
import com.google.firebase.auth.AuthCredential

interface AuthRepository {
    suspend fun signInGoogle(credentials: AuthCredential): AuthResult
    suspend fun addUserToDb(user: UserInfo): Boolean
    fun getCurrentUser(): UserInfo?
}