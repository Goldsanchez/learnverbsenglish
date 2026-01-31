package com.goldsanchez.learnverbsenglish.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldsanchez.learnverbsenglish.data.AuthRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    val currentUser: StateFlow<FirebaseUser?> = repository.currentUser

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var name by mutableStateOf("")
    
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun signIn(onSuccess: () -> Unit) {
        if (email.isBlank() || password.isBlank()) {
            errorMessage = "Por favor, rellena todos los campos"
            return
        }
        
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            val result = repository.signIn(email, password)
            isLoading = false
            
            result.onSuccess { onSuccess() }
            result.onFailure { errorMessage = it.localizedMessage ?: "Error al iniciar sesión" }
        }
    }

    fun signUp(onSuccess: () -> Unit) {
        if (email.isBlank() || password.isBlank() || name.isBlank()) {
            errorMessage = "Por favor, rellena todos los campos"
            return
        }

        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            val result = repository.signUp(email, password, name)
            isLoading = false
            
            result.onSuccess { onSuccess() }
            result.onFailure { errorMessage = it.localizedMessage ?: "Error al registrarse" }
        }
    }

    fun resetPassword() {
        if (email.isBlank()) {
            errorMessage = "Escribe tu email para restablecer la contraseña"
            return
        }
        viewModelScope.launch {
            repository.resetPassword(email)
            errorMessage = "Se ha enviado un correo de recuperación"
        }
    }
}
