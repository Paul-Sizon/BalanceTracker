package com.balance.tracker.auth.api

import com.balance.tracker.auth.domain.AuthResult
import com.balance.tracker.auth.domain.AuthSideEffect
import com.balance.tracker.data.FirestoreManager
import com.balance.tracker.data.db.UserInfo
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseAuthRepositoryImpl @Inject constructor() : AuthRepository {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val fireStore = Firebase.firestore

    override suspend fun signInGoogle(credentials: AuthCredential): AuthResult =
        suspendCoroutine { continuation ->
            firebaseAuth.signInWithCredential(credentials).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val isNewUser = task.result?.additionalUserInfo?.isNewUser == true
                    val firebaseUser = firebaseAuth.currentUser ?: kotlin.run {
                        continuation.resumeWithException(Exception())
                        return@addOnCompleteListener
                    }
                    //TODO check if email always returns
                    val accountInfo = getUserInfo(firebaseUser)
                    val sideEffect =
                        if (isNewUser) listOf(AuthSideEffect.PushToFirebase)
                        else emptyList()

                    continuation.resumeWith(
                        Result.success(
                            AuthResult(
                                accountInfo,
                                sideEffect
                            )
                        )
                    )
                } else {
                    continuation.resumeWithException(task.exception ?: Exception())
                }
            }
        }

    private fun getUserInfo(user: FirebaseUser?): UserInfo? =
        if (user == null) null else UserInfo(
            name = user.displayName,
            email = user.email ?: "Unknown email",
            uid = user.uid,
        )

    override suspend fun addUserToDb(user: UserInfo): Boolean =
        suspendCoroutine { continuation ->
            fireStore.collection(FirestoreManager.USERS_COLLECTION).document(user.uid).set(user)
                .addOnSuccessListener {
//                    it.id
//                    Log.d(MainActivityKt.TAG, "DocumentSnapshot added with path: ${it.path}")
//                    Log.d(MainActivityKt.TAG, "DocumentSnapshot added with ID: ${it.id}")
                    continuation.resumeWith(Result.success(true))
                }
                .addOnFailureListener {
                    Timber.e(it)
                    continuation.resumeWith(Result.failure(FirestoreUpdateError()))
                }
        }

    override fun getCurrentUser(): UserInfo? {
        return getUserInfo(firebaseAuth.currentUser)
    }
}