package com.goldsanchez.learnverbsenglish.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthRepository(
    private val revenueRepository: RevenueRepository,
    private val progressRepository: ProgressRepository
) {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _currentUser = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val currentUser: StateFlow<FirebaseUser?> = _currentUser

    init {
        auth.addAuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            _currentUser.value = user
            if (user != null) {
                revenueRepository.logIn(user.uid)
                // Cargamos progreso de la nube y lo unimos al local
                CoroutineScope(Dispatchers.IO).launch {
                    progressRepository.fetchProgress(user.uid)
                }
            }
            // Eliminamos el clearProgress() de aquí para que los free users mantengan su progreso local
        }
    }

    suspend fun signUp(email: String, password: String, name: String): Result<FirebaseUser?> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build()
            user?.updateProfile(profileUpdates)?.await()
            user?.uid?.let { uid ->
                revenueRepository.logIn(uid)
                progressRepository.fetchProgress(uid)
            }
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signIn(email: String, password: String): Result<FirebaseUser?> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val user = result.user
            user?.uid?.let { uid ->
                revenueRepository.logIn(uid)
                progressRepository.fetchProgress(uid)
            }
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun signOut() {
        auth.signOut()
        revenueRepository.logOut()
        // Aquí SÍ borramos el progreso porque es un cierre de sesión explícito
        progressRepository.clearProgress()
    }

    suspend fun resetPassword(email: String): Result<Unit> {
        return try {
            auth.sendPasswordResetEmail(email).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
