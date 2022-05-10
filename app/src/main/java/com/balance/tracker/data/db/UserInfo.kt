package com.balance.tracker.data.db

import com.google.firebase.firestore.DocumentId

data class UserInfo(
    @DocumentId
    val uid: String,
    val name: String?,
    val email: String,
)