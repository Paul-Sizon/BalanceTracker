package com.balance.tracker.auth

import android.annotation.SuppressLint
import android.content.Context
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balance.tracker.auth.api.AuthRepository
import com.balance.tracker.auth.domain.AuthResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
class AuthViewModel @Inject constructor(
    private val context: Context,
    private val repo:AuthRepository
) : ViewModel() {

    val googleSignInClient: GoogleSignInClient

    init {
        val options = getSignInOptions()
        googleSignInClient = GoogleSignIn.getClient(context,options)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
    }

    private fun getSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(GOOGLE_ID_TOKEN)
            .requestEmail()
            .build()
    }

    fun handleGoogleAuthResult(result: ActivityResult) {
        Timber.v("handleGoogleAuthResult")
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val googleSignInAccount = task.getResult(ApiException::class.java)
            if (googleSignInAccount != null) {
                handleGoogleSuccess(googleSignInAccount)
            }
        } catch (e: ApiException) {
            handleGoogleFailure(e)
        }
    }

    private fun handleGoogleSuccess(account: GoogleSignInAccount) = viewModelScope.launch {
        Timber.v("handleGoogleSuccess")
        val googleTokenId = account.idToken
        val googleAuthCredential = GoogleAuthProvider.getCredential(googleTokenId, null)
//        uiState.value = UiState.Loading
        try {
            val result = repo.signInGoogle(googleAuthCredential)
            processAuthResults(result)
        } catch (e: Exception) {
//            uiState.value = UiState.Idle
//            eventChannel.trySend(UiEvent.Error())
            Timber.e(e, e.message.toString())
        }
    }

    private fun processAuthResults(result: AuthResult) {
        Timber.v("handleAuthResult")
        if (result.user == null) {
//            uiState.value = UiState.Error()
            return
        }
//        uiState.value = UiState.Idle
        Timber.v(result.toString())
//        handleSideEffects(result.sideEffects, result.user)
    }

    private fun handleGoogleFailure(e: ApiException) {
        Timber.e(e, e.message)
    }

    companion object {
        private const val GOOGLE_ID_TOKEN = "797894789206-r69rmti37aksequgervj9tfa4bv1p4mf.apps.googleusercontent.com"
    }

}