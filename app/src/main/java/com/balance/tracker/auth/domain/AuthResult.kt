package com.balance.tracker.auth.domain

import com.balance.tracker.data.db.UserInfo

data class AuthResult(val user: UserInfo?, val sideEffects: List<AuthSideEffect>)

enum class AuthSideEffect {
    PushToFirebase, Succeed
}