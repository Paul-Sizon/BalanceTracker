package com.balance.tracker.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirestoreManager {

    private val fireStore = Firebase.firestore

    companion object {
        const val USERS_COLLECTION = "users"
        const val TRAINS_COLLECTION = "trains"
    }
}